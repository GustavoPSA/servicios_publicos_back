package com.servicios.publicos.back.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.publicos.back.app.domain.dto.MaterialDTO;
import com.servicios.publicos.back.app.service.IMaterialService;

@RestController
@RequestMapping("/materiales")
public class MaterialController {

	@Autowired
	private IMaterialService service;

	@GetMapping
	public ResponseEntity<List<MaterialDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}

	@PostMapping
	public ResponseEntity<MaterialDTO> agregar(@RequestBody MaterialDTO materialDto) {

		return ResponseEntity.ok(service.add(materialDto));
	}

	@PutMapping
	public ResponseEntity<MaterialDTO> editar(@RequestBody MaterialDTO materialDto) {

		return ResponseEntity.ok(service.edit(materialDto));
	}
}
