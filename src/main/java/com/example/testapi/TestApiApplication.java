package com.example.testapi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.testapi.dao.SystemRepository;

@SpringBootApplication
@EnableJpaRepositories("com.example.testapi.dao")
@EntityScan("com.example.testapi.model")
public class TestApiApplication implements CommandLineRunner{
	

    @Autowired
    DataSource dataSource;
    @Autowired
    SystemRepository systemRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Our DataSource is = " + dataSource);
        Iterable<com.example.testapi.model.SystemExample> systemlist = systemRepository.findAll();
        for(com.example.testapi.model.SystemExample systemmodel:systemlist){
            System.out.println("Here is a system: " + systemmodel.toString());
        }
        
        System.out.println("findOne = " + systemRepository.findUserById());
		
	}

}
