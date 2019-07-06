package com.example.testapi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * This Main Controller
 * @author Md.Rafiqul
 *
 */

import com.example.testapi.utils.NecessaryMethod;
@Controller
public class MainController {
	
	// Return index.html page when hit http://localhost:8080/
	@GetMapping("/")
	public String index() {
		
		System.out.println("Random Token: " + NecessaryMethod.tokenGenerator());
		
		return "index";
	}
	
}
