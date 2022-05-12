package com.ashspell.movie.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	// ??Έ? λ©μ?
		public static String md5(String message) {
			String resultData = "";
			
			
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				
				// λ¬Έμ?΄? byte λ°°μ΄λ‘? λ³??
				byte[] bytes = message.getBytes();
				// ??Έ? ??
				md.update(bytes);
				
				//??Έ?? κ²°κ³Ό ?»κΈ?
				byte[] digest = md.digest();
				
				// byte λ°°μ΄ -> 16μ§μ λ¬Έμ?΄
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
