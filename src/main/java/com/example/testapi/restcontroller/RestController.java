package com.example.testapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.testapi.dao.SystemRepository;
import com.example.testapi.model.SystemExample;
/**
 * Rest Controller Mapping class
 * @author Md.Rafiqul
 *
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
    SystemRepository systemRepository;
	
	/**
	 * Get the SystemExample type list
	 * @param headerPersist -> catch the "x-api-key" from httpHeaders according to given name
	 * 							and required = true means you have to must give header value
	 * @return -> User List
	 * @throws Exception
	 */
	@GetMapping("/rest")
    public List<SystemExample> getUser(@RequestHeader(name = "x-api-key", required = true) String headerPersist)throws Exception {
		
		// Return Only one SystemExample entity
		return (List<SystemExample>) systemRepository.findUserById();
		
    }
}
