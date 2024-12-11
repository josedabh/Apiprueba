package com.crud.angular.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.angular.model.Pais;
import com.crud.angular.services.PaisService;

@RestController
@RequestMapping(path = "api/pais")
public class PaisController {

	@Autowired
	private PaisService paisService;
	
	@GetMapping
	private ResponseEntity<List<Pais>> getAllPaises() {
		return ResponseEntity.ok(paisService.findAll());
	}
}
