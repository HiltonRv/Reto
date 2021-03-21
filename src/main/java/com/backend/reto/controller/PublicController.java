package com.backend.reto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.reto.dto.GenericDTO;
import com.backend.reto.service.IPublicService;

@RestController
@RequestMapping("/api")
public class PublicController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PublicController.class);
	@Autowired
	private IPublicService iPublicService;
		
	@PostMapping("/data")
	public ResponseEntity<?> start(@RequestBody GenericDTO genericDTO){
		LOG.info("procesando POST para PostMapping /api/data");

		List<String> listString = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		try {
			//enviando al service
			listString = iPublicService.findByIdPost(genericDTO.getPostId());
			//validando datos 
			if (listString.size() > 0) {
				response.put("resulCode", HttpStatus.OK.name());
				response.put("data", listString);
			}else {
				response.put("resulCode", HttpStatus.NO_CONTENT.name());
				response.put("data", listString);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			LOG.info("Error PostMapping /api/data", e);
			response.put("resulCode", HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	
	}

}
