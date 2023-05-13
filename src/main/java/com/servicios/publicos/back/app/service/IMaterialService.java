package com.servicios.publicos.back.app.service;

import java.util.List;

import com.servicios.publicos.back.app.domain.dto.MaterialDTO;

public interface IMaterialService {

	public List<MaterialDTO> listar();

	public MaterialDTO listarId(int idMaterial);

	public MaterialDTO add(MaterialDTO materialDto);

	public MaterialDTO edit(MaterialDTO materialDto);
}
