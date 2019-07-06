package com.example.testapi.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.testapi.model.SystemExample;

@Repository
public interface SystemRepository extends CrudRepository<SystemExample,Long>{
	
	@Query(
	value = "SELECT * FROM system_example s WHERE s.id = 1", 
	nativeQuery = true)
	public Iterable<SystemExample> findUserById();
}
