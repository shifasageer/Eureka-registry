package com.iiht.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/rest/client")
public class HelloClient {
	
	@Autowired
	RestTemplate template;
	
//	@GetMapping
//	public String connect() {
//		
//		String url ="http://localhost:8071/rest/services";
//		ResponseEntity<String> response = template.getForEntity(url, String.class);		
//		return response.toString();
//		}
	
	@GetMapping
	public String connect() {
		
		String url ="http://localhost:8071/rest/service/message";
		ResponseEntity<String> response = template.getForEntity(url, String.class);		
		return response.toString();
		}
   
	@GetMapping("/{n}")
	public ResponseEntity<String> factorial(@PathVariable Long n) {
		String strValue = String.valueOf(n);
		
		String url ="http://localhost:8071/rest/service/"+strValue;
		//ResponseEntity<String> response = template.getForEntity(url, String.class);		
		String res = template.getForObject(url, String.class);
		return ResponseEntity.ok(res);
		}
	
}
