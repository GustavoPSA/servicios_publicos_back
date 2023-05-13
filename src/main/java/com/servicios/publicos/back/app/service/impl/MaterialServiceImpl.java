package com.servicios.publicos.back.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicios.publicos.back.app.domain.dto.MaterialDTO;
import com.servicios.publicos.back.app.domain.mapper.MaterialMapper;
import com.servicios.publicos.back.app.domain.models.Material;
import com.servicios.publicos.back.app.repository.MaterialRepository;
import com.servicios.publicos.back.app.service.IMaterialService;

@Service
public class MaterialServiceImpl implements IMaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private MaterialMapper materialMapper;

	@Override
	@Transactional(readOnly = true)
	public List<MaterialDTO> listar() {

		List<Material> materiales = materialRepository.findAll();

		List<MaterialDTO> materialesDTO = new ArrayList<>();

		if (!materiales.isEmpty()) {
			materialesDTO = materialMapper.toListDTO(materiales);
		}

		return materialesDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public MaterialDTO listarId(int idMaterial) {
		// TODO Auto-generated method stub
		return materialMapper.entityToDto(materialRepository.findById(idMaterial).get());
	}

	@Override
	@Transactional(readOnly = false)
	public MaterialDTO add(MaterialDTO materialDto) {

		Material material = materialMapper.dtoToEntity(materialDto);

		Material materialResponse = materialRepository.save(material);

		// TODO Auto-generated method stub
		return materialMapper.entityToDto(materialResponse);
	}

	@Transactional
	@Override
	public MaterialDTO edit(MaterialDTO materialDto) {
		// TODO Auto-generated method stub
		Material material = materialMapper.dtoToEntity(materialDto);

		if (materialRepository.existsById(material.getIdMaterial())) {

			Material materialResponse = materialRepository.save(material);

			return materialMapper.entityToDto(materialResponse);
		} else {
			MaterialDTO materialResponse = null;
			return materialResponse;
		}

	}
}
