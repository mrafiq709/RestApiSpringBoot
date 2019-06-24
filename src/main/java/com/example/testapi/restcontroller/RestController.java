package com.example.testapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.testapi.dao.SystemRepository;
import com.example.testapi.model.SystemExample;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
    SystemRepository systemRepository;
	
	@GetMapping("/rest")
    public List<SystemExample> getUser() {
        return (List<SystemExample>) systemRepository.findUserById();
    }
}
