package com.servicios.publicos.back.app.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.servicios.publicos.back.app.domain.dto.MaterialDTO;
import com.servicios.publicos.back.app.domain.models.Material;
import com.servicios.publicos.back.app.domain.models.QMaterial;
import com.servicios.publicos.back.app.service.IMaterialService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private IMaterialService service;

	@GetMapping
	public ResponseEntity<List<MaterialDTO>> listar(@QuerydslPredicate(root = Material.class) Predicate predicate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCompra) {

		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(predicate);

		if (null != fechaCompra) {
			booleanBuilder.and(QMaterial.material.fechaCompra.eq(fechaCompra));
		}

		predicate = booleanBuilder;

		return ResponseEntity.ok(service.list(predicate));
	}

	@GetMapping("/{idMaterial}")
	public ResponseEntity<MaterialDTO> consultarId(@PathVariable("idMaterial") int idMaterial) {

		return ResponseEntity.ok(service.getById(idMaterial));
	}

	@PostMapping
	public ResponseEntity<MaterialDTO> agregar(@RequestBody @Valid MaterialDTO materialDto) {

		return ResponseEntity.ok(service.add(materialDto));
	}

	@PutMapping
	public ResponseEntity<MaterialDTO> editar(@RequestBody @Valid MaterialDTO materialDto) {

		return ResponseEntity.ok(service.edit(materialDto));
	}
}
