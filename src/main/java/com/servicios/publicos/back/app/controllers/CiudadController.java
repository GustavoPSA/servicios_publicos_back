package com.servicios.publicos.back.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.publicos.back.app.domain.dto.CiudadDTO;
import com.servicios.publicos.back.app.service.ICiudadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private ICiudadService service;

	@GetMapping
	public ResponseEntity<List<CiudadDTO>> listar() {

		return ResponseEntity.ok(service.list());
	}

}
