package com.example.testapi.restcontroller;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		
		/**
		 * Generate Random Key/Token
		 */
		final SecureRandom secureRandom = new SecureRandom(); //threadsafe
		final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
		
		byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    
	    System.out.println("Random Key Generator: "+ base64Encoder.encodeToString(randomBytes));
		
		return "index";
	}
	
}
