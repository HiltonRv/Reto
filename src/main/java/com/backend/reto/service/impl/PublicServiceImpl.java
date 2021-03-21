package com.backend.reto.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.reto.dto.GenericDTO;
import com.backend.reto.service.IPublicService;

@Service
public class PublicServiceImpl implements IPublicService{
	
	@Value("${service.url}")
	private String SERVICE_URL;
	
	@Override
	public List<String> findByIdPost(int postId) {
		
		List<GenericDTO> lstGenericDTO = new ArrayList<>();
		List<String> listString = new ArrayList<>();
		
		String URL = SERVICE_URL+String.valueOf(postId);
		try {
			//consumiendo servicio	
			RestTemplate clientRest = new RestTemplate();
			lstGenericDTO = Arrays.asList(clientRest.getForObject(URL, GenericDTO[].class));	
			
			//conversion array string
			for(GenericDTO obj : lstGenericDTO) {			
				String valor = obj.getPostId()+"|"+obj.getId()+"|"+obj.getEmail();
				listString.add(valor);	
			}			
		} catch (Exception e) {
			throw e;
		}
		return listString;
	}

}
