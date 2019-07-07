package com.example.testapi.errorhandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Custom Error Controller class
 * @author Md.Rafiqul
 *
 */
@Controller
public class MyErrorController implements ErrorController{

	/**
	 * Error Handler Method
	 * @param request -> HttpServletRequest
	 * @return -> Particular Error Page
	 */
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		
		// Get the Error status code
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    // Check What Type of Error
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        // Return "error-404.html" if NOT_FOUND
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        // return "error-500.html" for INTERNAL_SERVER_ERROR
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    }
	    // Return "error.html" for Any Other Kind of error
	    return "error";
	}
	
	/**
	 * Get the Actual error from above handleError method
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
