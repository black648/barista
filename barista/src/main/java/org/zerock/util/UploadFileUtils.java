package org.zerock.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.zerock.domain.AttachVO;
import org.zerock.domain.EduApplicantAttachVO;
import org.zerock.domain.ExamApplicantAttachVO;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static AttachVO uploadFile(String uploadPath,String savedFileNm, String originalName, byte[] fileData)throws Exception {
		
		AttachVO attachVO = new AttachVO();
		UUID uid = UUID.randomUUID();
		int idx = originalName.indexOf(".");
		//String savedName = uid.toString()+"_."+originalName.substring(idx+1);
		
		String savedName = savedFileNm+"."+originalName.substring(idx+1);
		String savedPath = calcPath(uploadPath); // ����� ��θ� �����.
		
		File target = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(fileData, target); //���� ������ �����ϴ� �κ�
		
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		
		if(MediaUtils.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath,savedPath,savedName);
		}
		else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		attachVO.setSavedfilename(savedName);
		attachVO.setDirpath(uploadPath+savedPath);
		
		return attachVO;
	}
	
	
	public static AttachVO uploadFile2(String uploadPath, String originalName, byte[] fileData)throws Exception {
		
		AttachVO attachVO = new AttachVO();
		UUID uid = UUID.randomUUID();
		int idx = originalName.indexOf(".");
		//String savedName = uid.toString()+"_."+originalName.substring(idx+1);
		
		String savedName = uid.toString()+"_."+originalName.substring(idx+1);
		String savedPath = calcPath(uploadPath); // ����� ��θ� �����.
		
		File target = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(fileData, target); //���� ������ �����ϴ� �κ�
		
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		
		if(MediaUtils.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath,savedPath,savedName);
		}
		else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		attachVO.setSavedfilename(savedName);
		attachVO.setDirpath(savedPath.substring(1));
		
		return attachVO;
	}
	
	
	public static ExamApplicantAttachVO uploadApplicantFile(String uploadPath, String originalName, byte[] fileData)throws Exception {
		
		ExamApplicantAttachVO attachVO = new ExamApplicantAttachVO();
		UUID uid = UUID.randomUUID();
		int idx = originalName.indexOf(".");
		//String savedName = uid.toString()+"_."+originalName.substring(idx+1);
			
		String savedName = uid.toString()+"_."+originalName.substring(idx+1);
		String savedPath = calcPath(uploadPath); // ����� ��θ� �����.
			
		File target = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(fileData, target); //���� ������ �����ϴ� �κ�
			
			
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
			
		if(MediaUtils.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath,savedPath,savedName);
		}
		else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
			
		attachVO.setSavedfilename(savedName);
		attachVO.setDirpath(savedPath.substring(1));
			
		return attachVO;
	}
	
	
	public static EduApplicantAttachVO uploadEduApplicantFile(String uploadPath, String originalName, byte[] fileData)throws Exception {
		
		EduApplicantAttachVO attachVO = new EduApplicantAttachVO();
		UUID uid = UUID.randomUUID();
		int idx = originalName.indexOf(".");
		//String savedName = uid.toString()+"_."+originalName.substring(idx+1);
			
		String savedName = uid.toString()+"_."+originalName.substring(idx+1);
		String savedPath = calcPath(uploadPath); // ����� ��θ� �����.
			
		File target = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(fileData, target); //���� ������ �����ϴ� �κ�
			
			
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
			
		if(MediaUtils.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath,savedPath,savedName);
		}
		else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
			
		attachVO.setSavedfilename(savedName);
		attachVO.setDirpath(savedPath.substring(1));
			
		return attachVO;
	}
	
	
	
	public static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath=monthPath +new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		//String dir = yearPath+monthPath+datePath; 
		
		//makeDir(uploadPath, yearPath, monthPath, datePath);
		makeDir(uploadPath, datePath);
		return datePath;
	}
	
	
	//���� ���ε� ��θ� ����
	private static void makeDir(String uploadPath, String datePath){
		//String... paths ->  yearPath, monthPath, datePath �κ�
//		System.out.println("paths : " + paths);
		
//		if(new File(paths[paths.length-1]).exists()) {
//			return;
//		}
//		for (String path : paths) {
//			File dirPath = new File(uploadPath+path);
//			if(!dirPath.exists()) {
//				dirPath.mkdir();
//			}
//		}
		
		File dirPath = new File(uploadPath+datePath);
		if(!dirPath.exists()) {
			dirPath.mkdir();
		}
		
	}
	
	//���� ����� �����
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+path,fileName));
		
		//Scalr.Method -> ������� ó���Ұ���. (��ȭ��,����ó��, ����)
		//Scalr.Mode -> FIT_EXACT(������ ����� �°�) , FIT_HEIGHT(���̱�������), FIT_WIDTH(���� ��������)
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.QUALITY,Scalr.Mode.FIT_EXACT,167,199,Scalr.OP_ANTIALIAS);
		
		//BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		String thumbnailName = uploadPath+path+File.separator+"s_"+fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar,'/');
		
	}
	
	//���� ���ε� ó��
	public static String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
		UUID uid = UUID.randomUUID();
		int idx = originalName.indexOf(".");
		String savedName = uid.toString()+"_."+originalName.substring(idx+1);
		String savedPath = calcPath(uploadPath); // ����� ��θ� �����.
		
		File target = new File(uploadPath+savedPath, savedName);
		FileCopyUtils.copy(fileData, target); //���� ������ �����ϴ� �κ�
		
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		
		if(MediaUtils.getMediaType(formatName)!=null) {
			uploadedFileName = makeThumbnail(uploadPath,savedPath,savedName);
		}
		else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		return savedName;
	}
	private static String makeIcon(String uploadPath,String path, String fileName) throws Exception {
		String iconName = uploadPath + path + File.separator+fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar,'/');
	}
	
}
