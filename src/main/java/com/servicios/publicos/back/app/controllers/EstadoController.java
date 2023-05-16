package com.servicios.publicos.back.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.publicos.back.app.domain.dto.EstadoDTO;
import com.servicios.publicos.back.app.service.IEstadoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private IEstadoService service;

	@GetMapping
	public ResponseEntity<List<EstadoDTO>> listar() {

		return ResponseEntity.ok(service.list());
	}
}
