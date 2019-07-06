package com.example.testapi.errorhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.testapi.model.ErrorResponse;

// Hide unchecked, rawtypes type warning [Here ResponseEntity is unchecked and rawtypes warning]
@SuppressWarnings({"unchecked","rawtypes"})

/**
 *@ControllerAdvice -> is a global exception handler. From all controller it will be called.
 *					GlobalExceptionHandler was annotated with @ControllerAdvice, thus it is going 
 *					to intercept exceptions from controllers across the application.
 */
@ControllerAdvice

/**
 * Custom Exception Class for Error Handling
 * @author Md.Rafiqul
 *
 */
public class CustomExceptionHandler {

	/**
	 * @ExceptionHandler(ServletRequestBindingException.class) -> Here Assign the particular class of exception 
	 * 			which exception we want to handle manually. We can add more than one exception class like->
	 * 			@ExceptionHandler({Exception_1.class, Exception_2.class, etc})
	 * 
	 * @param ex -> Exception
	 * @param request -> WebRequest
	 * @return -> Custom Error
	 */
	 	@ExceptionHandler(ServletRequestBindingException.class)
	    public final ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request)
	    {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Bad Request", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	    }
	     
	    @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)
	    {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Server Error", details);
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
