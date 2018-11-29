package com.lpdm.msconfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MsConfigApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MsConfigApplicationTests {

	@LocalServerPort
	int port;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void contextLoads() throws JsonProcessingException {

		final String uri = "http://localhost:" + port + "/lpdm/title";
		RestTemplate restTemplate = new RestTemplate();


		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(restTemplate.getForObject(uri, String.class));

		System.out.println(result);
	}

}
