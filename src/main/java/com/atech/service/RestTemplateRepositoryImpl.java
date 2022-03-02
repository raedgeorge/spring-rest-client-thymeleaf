package com.atech.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateRepositoryImpl implements RestTemplateRepository {

	@Override
	public RestTemplate geRestTemplate() {
		
		return new RestTemplate();
	}

}
