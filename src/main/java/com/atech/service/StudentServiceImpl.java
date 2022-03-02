package com.atech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.atech.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService{
	
	private final RestTemplateRepository restTemplateRepository;
	
	@Autowired
	@Value("${resturl}")
	private String url;
	
	@Autowired	
	public StudentServiceImpl(RestTemplateRepository restTemplateRepository) {
		this.restTemplateRepository = restTemplateRepository;
	}


	@Override
	public List<Student> getStudents() {
		
		ResponseEntity<List<Student>> responseEntity = restTemplateRepository
                .geRestTemplate().exchange(url, HttpMethod.GET,null, 
				new ParameterizedTypeReference<List<Student>>() {});
		
		
		List<Student> thesStudents = responseEntity.getBody();
		
		return thesStudents;
	}

}
