package org.zerock.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.domain.AttachVO;
import org.zerock.service.AttachService;
import org.zerock.util.MediaUtils;
import org.zerock.util.UploadFileUtils;

@Controller
public class UploadController {

	@Resource(name="uploadPath")
	private String uploadPath;

	
	@Inject AttachService service;
	
	
/*	
	@ResponseBody
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		//logger.info("originalName : " + file.getOriginalFilename());
		
		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),HttpStatus.CREATED);
	}*/
	
	@ResponseBody
	@RequestMapping("/displayFile") //�Ķ���ͷ� ���������� ���۹ޱ� ���ϴ� ������ �̸��� ����.
	public ResponseEntity<byte[]> displayFile(HttpServletRequest request) throws Exception {
		/*
		���������� �����ϴ� ResponseEntity Ÿ���� �����ڰ� ���� ��� ������ + HTTP�� ���� �ڵ带 ���� ������ �� �ִ� Ŭ�����̴�.
		ResponseEntity�� �̿��Ը� �����ڴ� 404, 500���� HTTP ���� �ڵ带 �����ϰ� ���� �����Ϳ� �Բ� ������ �� �ֱ� ������ �� �� ������ ��� �ʿ��� ��쿡 ����Ѵ�.
		*/
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = request.getParameter("file_mask_name");
		String path = request.getParameter("path");
		System.out.println("path : "+path);
		System.out.println("displayFile���� : " + fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+File.separator+path+File.separator+fileName);
			
			if(mType!=null) {
				headers.setContentType(mType);
			}else {
				System.out.println("�ٿ�ε�� ����");
				fileName=fileName.substring(fileName.indexOf("_")+1);
				System.out.println(fileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); //�ٿ�ε� ������ ���Ǵ� application/octet-stream ���� ����
				headers.add("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); //�ѱ�ó��
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
			System.out.println(entity);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]> (HttpStatus.BAD_REQUEST);
		}finally{
			in.close();
		}
		return entity;
	}
	
	
//	@RequestMapping("/file/upload")
//	public void UploadFile(MultipartFile file, Model model, AttachVO vo) throws Exception {
//		String filePath=UploadFileUtils.calcPath(uploadPath);
//		
//		System.out.println("file : "+file);
//		System.out.println("filename"+file.getName());
//		System.out.println("fileOname"+file.getOriginalFilename());
//		System.out.println("getBytes"+file.getBytes());
//		System.out.println("getSeqNo"+vo.getSeqno());
//		
//		int seq = vo.getSeqno();
//		String savedName="";
//		
//		
//		if((Integer)vo.getSeqno()==null) {
//			vo.setSeqno(vo.getSeqno());
//			vo.setSavedfilename((vo.getSeqno()*1000)+1);
//			
//			savedName = Integer.toString(vo.getSavedfilename());
//		} else {
//			vo.setSavedfilename(vo.getSeqno()+1);
//			savedName = Integer.toString(vo.getSavedfilename());
//		}
//		
//		UploadFileUtils.uploadFile(file.getOriginalFilename(),file.getBytes(), uploadPath,savedName );
//		
//		
//		// ��������� : ���Ͻ����� + 001 �̺κ� �����ؤ�����...........
//		// AttachVO.setSavedfilename(UploadFileUtils.uploadFile(file.getOriginalFilename(),file.getBytes(), uploadPath ));
//		vo.setOrgfilename(file.getOriginalFilename());
//
//		//���� ��ο� / �� �����ϱ� ���� �Ʒ��� ���� ���ڿ��� �ڸ�.
//		int idx = filePath.indexOf(File.separator);
//		vo.setDirpath(filePath.substring(idx+1));
//		
//		service.insertAttach(vo);
//		
//	}
//	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/file/upload",method=RequestMethod.POST ,produces="text/plain;charset=UTF-8")
	public ResponseEntity<AttachVO> uploadAjax1(MultipartHttpServletRequest request) throws Exception {
		Iterator<String> itr = request.getFileNames(); 
		System.out.println(request.getFileNames());
		int seqno = Integer.parseInt(request.getParameter("seqno"));
		String division = request.getParameter("division");
		String str_seq;
		int savedFileNm ;
	
		AttachVO attachVO = new AttachVO();
		if(itr.hasNext()) { 
			MultipartFile mpf = request.getFile(itr.next()); 
			System.out.println(mpf.getOriginalFilename() +" uploaded!"); 
			try { 
				//just temporary save file info into ufile 
				
				attachVO.setSeqno(seqno);
				attachVO.setDivision(division);
				List<AttachVO> fileList = service.getFileList(attachVO);
				AttachVO fileOne =null;
				
				if(fileList.size()>0) {
					fileOne=service.getFileList(attachVO).get(0);
				}
				
				
				//20180215 savedName ���� �߰�
				if(fileOne==null || "".equals(fileOne)) {
					str_seq=String.valueOf(seqno)+"001";
					//savedFileNm=Integer.valueOf(str_seq);
				}else {
					str_seq=String.valueOf(seqno+1);
				}
				
				
				System.out.println("file length : " + mpf.getBytes().length); 
				System.out.println("file getSize : " + mpf.getSize()); 
				System.out.println("file name : " + mpf.getOriginalFilename()); 
				
				
				
				
			//	return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath,str_seq, mpf.getOriginalFilename(), mpf.getBytes() ), HttpStatus.CREATED);
				attachVO =UploadFileUtils.uploadFile(uploadPath,str_seq, mpf.getOriginalFilename(), mpf.getBytes() );
				attachVO.setGrpno(seqno);
				attachVO.setDivision(division);
				attachVO.setOrgfilename(mpf.getOriginalFilename());
				attachVO.setState("Y");
				attachVO.setUpd_id("");
				System.out.println(attachVO.toString());
				service.insertAttach(attachVO);
				
			} 
			catch (IOException e) {
				System.out.println(e.getMessage()); 
				e.printStackTrace(); 
			} 
			
		}else{
			System.out.println("�����;���...");
		}
		
		
		
		return new ResponseEntity<AttachVO>(attachVO, HttpStatus.CREATED);

		
	}
	
	
	
	
	

	
	
	
}
