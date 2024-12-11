package com.crud.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.angular.model.Estado;
import com.crud.angular.services.EstadoService;

@RestController
@RequestMapping(path = "api/estado")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	private ResponseEntity<List<Estado>> getAllEstado() {
		return ResponseEntity.ok(estadoService.findAll());
	}
	
	//Tambien puedes ponerle a @PathVariable(name) donde se vincule con getMapping
	@GetMapping(path = "{idPais}")
	private ResponseEntity<List<Estado>> getAllEstadosByPais(@PathVariable int idPais){
		return ResponseEntity.ok(estadoService.findAllByCountry(idPais));
	}
}
