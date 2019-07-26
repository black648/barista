package org.zerock.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.zerock.domain.AttachVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.service.AttachService;
import org.zerock.util.MediaUtils;

public class FileServlet extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		
		String fileName = request.getParameter("savedfilename");
		String fileOname = request.getParameter("orgfilename");
		String path = request.getParameter("dirpath");
		

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream("C:\\fileUpload"+File.separator+path+File.separator+fileName);
			
			
			if(mType!=null) {
				headers.setContentType(mType);
			}else {
				System.out.println("다운로드용 파일");
				//fileName=fileName.substring(fileName.indexOf("_")+1);
				System.out.println(fileName);
				//headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); //다운로드 용으로 사용되는 application/octet-stream 으로 지정
				//headers.add("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); //한글처리

				//블로그 참조하여 아래내용으로 변경
				response.setHeader("Content-Disposition", "attachment; filename=\""+ new String(fileOname.getBytes("UTF-8"), "ISO-8859-1")+"\"");
				response.setHeader("Content-Transfer-Encoding", "binary");
				//여기까지
			}
			//아웃스트림에 response 헤더값을 담은 후 파일을 카피
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(in, out);
			//response.getOutputStream();
		}catch(Exception e) {
			e.printStackTrace();
			//entity = new ResponseEntity<byte[]> (HttpStatus.BAD_REQUEST);
		}finally{
			IOUtils.closeQuietly(in);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = request.getParameter("file_mask_name");
		String path = request.getParameter("path");
		
		System.out.println("downFile접근 : " + fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream("C:\\fileUpload"+File.separator+path+File.separator+fileName);
			
			if(mType!=null) {
				headers.setContentType(mType);
			}else {
				System.out.println("다운로드용 파일");
				fileName=fileName.substring(fileName.indexOf("_")+1);
				System.out.println(fileName);
				//headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); //다운로드 용으로 사용되는 application/octet-stream 으로 지정
				//headers.add("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); //한글처리

				response.setHeader("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
				response.setHeader("Content-Transfer-Encoding", "binary");
			}
			OutputStream out = response.getOutputStream();
			FileCopyUtils.copy(in, out);
			response.getOutputStream();
		}catch(Exception e) {
			e.printStackTrace();
			//entity = new ResponseEntity<byte[]> (HttpStatus.BAD_REQUEST);
		}finally{
			IOUtils.closeQuietly(in);
		}
		
	}
	 */
	
	
	
}
