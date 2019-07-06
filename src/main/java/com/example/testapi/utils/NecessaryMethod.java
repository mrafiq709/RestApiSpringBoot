package com.example.testapi.utils;

import java.security.SecureRandom;
import java.util.Base64;
/**
 * Class for Necessary Method
 * @author Md.Rafiqul
 *
 */
public class NecessaryMethod {
	
	/**
	 * Generate Random Key/Token
	 * @return -> Generated Token
	 */
	public static String tokenGenerator() {
		
		final SecureRandom secureRandom = new SecureRandom(); //threadsafe
		final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
		
		byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    
		return base64Encoder.encodeToString(randomBytes);
	}

}
