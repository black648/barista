package org.zerock.util;

import java.io.File;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class CommonUtil {
	public static String randomPassword(int length) {
		int index=0;
		char[] charSet=new char[] {
				'0','1','2','3','4','5','6','7','8','9'
				,'A','B','C','D','E','F','G','H','I','J'
				,'K','L','M','N','O','K','Q','R','S','T'
				,'U','V','W','X','Y','Z'
		};
		
		StringBuffer sb= new StringBuffer();
		for(int i=0; i<length; i++)	{
			index = (int) (charSet.length * Math.random());
			sb.append(charSet[index]);
		}
		return sb.toString();
	}
	
	public static String key4Change(String cutMaxKey) {
		
		int key = Integer.parseInt(cutMaxKey)+1;
		String resultKey ="";
		if(key<10) {
			resultKey="000"+ String.valueOf(key);
		}else if(key<100) {
			resultKey="00"+ String.valueOf(key);
		}else if(key<1000) {
			resultKey="0"+ String.valueOf(key);
		}else {
			resultKey=String.valueOf(key);
		}
		
		return resultKey;
	}
	

}
