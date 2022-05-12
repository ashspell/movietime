package com.ashspell.movie.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	// ?��?��?�� 메소?��
		public static String md5(String message) {
			String resultData = "";
			
			
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				
				// 문자?��?�� byte 배열�? �??��
				byte[] bytes = message.getBytes();
				// ?��?��?�� ?��?��
				md.update(bytes);
				
				//?��?��?��?�� 결과 ?���?
				byte[] digest = md.digest();
				
				// byte 배열 -> 16진수 문자?��
				// 01001001
				for(int i = 0; i < digest.length; i++) {
					 resultData += Integer.toHexString(digest[i] & 0xff);
					
			
				}
				
			} catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
				return null;
			}
			
			return resultData;
		}
		
}
