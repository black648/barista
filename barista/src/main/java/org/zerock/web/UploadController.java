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
	@RequestMapping("/displayFile") //파라미터로 브라우저에서 전송받기 원하는 파일의 이름을 받음.
	public ResponseEntity<byte[]> displayFile(HttpServletRequest request) throws Exception {
		/*
		스프링에서 제공하는 ResponseEntity 타입은 개발자가 직접 결과 데이터 + HTTP의 상태 코드를 직접 제어할 수 있는 클래스이다.
		ResponseEntity를 이용함면 개발자는 404, 500같은 HTTP 상태 코드를 전공하고 싶은 데이터와 함께 전송할 수 있기 때문에 좀 더 세밀한 제어가 필요한 경우에 사용한다.
		*/
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = request.getParameter("file_mask_name");
		String path = request.getParameter("path");
		
		System.out.println("displayFile접근 : " + fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+File.separator+path+File.separator+fileName);
			
			if(mType!=null) {
				headers.setContentType(mType);
			}else {
				System.out.println("다운로드용 파일");
				fileName=fileName.substring(fileName.indexOf("_")+1);
				System.out.println(fileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); //다운로드 용으로 사용되는 application/octet-stream 으로 지정
				headers.add("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); //한글처리
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
//		// 파일저장명 : 파일시퀀스 + 001 이부분 수정해ㅑㅇ함...........
//		// AttachVO.setSavedfilename(UploadFileUtils.uploadFile(file.getOriginalFilename(),file.getBytes(), uploadPath ));
//		vo.setOrgfilename(file.getOriginalFilename());
//
//		//파일 경로에 / 를 제거하기 위해 아래와 같이 문자열을 자름.
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
				
				
				//20180215 savedName 로직 추가
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
			System.out.println("데이터없음...");
		}
		
		
		
		return new ResponseEntity<>(attachVO, HttpStatus.CREATED);

		
	}
	
	
	
	
	

	
	
	
}
