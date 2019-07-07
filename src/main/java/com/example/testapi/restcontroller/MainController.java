package com.example.testapi.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.testapi.utils.NecessaryMethod;
/**
 * This Main Controller
 * @author Md.Rafiqul
 *
 */
@Controller
public class MainController {
	
	/**
	 * Home Page
	 * @return -> index.html page when hit http://localhost:8080/
	 */
	@GetMapping("/")
	public String index() {
		System.out.println("Random Token: " + NecessaryMethod.tokenGenerator());
		return "index";
	}
	
	/**
	 * Login Page
	 * @return -> login.html Page
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
