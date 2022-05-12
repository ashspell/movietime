package com.ashspell.movie.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	// ?•”?˜¸?™” ë©”ì†Œ?“œ
		public static String md5(String message) {
			String resultData = "";
			
			
			try {
				MessageDigest md = MessageDigest.getInstance("md5");
				
				// ë¬¸ìž?—´?„ byte ë°°ì—´ë¡? ë³??™˜
				byte[] bytes = message.getBytes();
				// ?•”?˜¸?šŒ ?…‹?Œ…
				md.update(bytes);
				
				//?•”?˜¸?™”?œ ê²°ê³¼ ?–»ê¸?
				byte[] digest = md.digest();
				
				// byte ë°°ì—´ -> 16ì§„ìˆ˜ ë¬¸ìž?—´
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
