package com.backend.reto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.backend.reto.dto.GenericDTO;
import com.backend.reto.service.IPublicService;
import com.backend.reto.service.impl.PublicServiceImpl;

@SpringBootTest
class PublicControllerTest {

	@Autowired
	private PublicController publicController;

	@Autowired private IPublicService iPublicService;

	@Test
	public void publicControllerTest() {

		GenericDTO genericDTO = new GenericDTO();
		assertThat(publicController.start(genericDTO)).isNotNull();

	}

	@Test
	public void iPublicServiceTest() {

		int postId = 1;

		List<String> result = iPublicService.findByIdPost(postId);

		assertTrue(result.size() > 0);

		/*
		 * assertThat(publicService.findByIdPost(postId)).isNotNull();
		 * 
		 * 
		 * ///////////////
		 *
		 * 
		 * 
		 * 
		 * when(iPublicService.findByIdPost(postId)).thenCallRealMethod();
		 */
	}

}
