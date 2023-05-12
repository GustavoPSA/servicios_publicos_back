package com.servicios.publicos.back.app.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicios.publicos.back.app.domain.dto.MaterialDTO;
import com.servicios.publicos.back.app.domain.mapper.MaterialCiudadMapper;
import com.servicios.publicos.back.app.domain.mapper.MaterialMapper;
import com.servicios.publicos.back.app.domain.models.Material;
import com.servicios.publicos.back.app.domain.models.MaterialCiudad;
import com.servicios.publicos.back.app.repository.MaterialCiudadRepository;
import com.servicios.publicos.back.app.repository.MaterialRepository;
import com.servicios.publicos.back.app.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private MaterialCiudadRepository materialCiudadRepository;

	@Autowired
	private MaterialMapper materialMapper;

	@Autowired
	private MaterialCiudadMapper materialCiudadMapper;

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

		List<MaterialCiudad> materialCiudadList = Optional.ofNullable(materialDto.getMaterialCiudadList())
				.orElseGet(Collections::emptyList).stream().peek(x -> x.setIdMaterial(materialResponse.getIdMaterial()))
				.map(x -> materialCiudadMapper.materialCiudadDtoToMaterialCiudad(x)).collect(Collectors.toList());

		materialCiudadRepository.saveAll(materialCiudadList);

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

			materialCiudadRepository.deleteByIdMaterial(materialResponse.getIdMaterial());

			List<MaterialCiudad> materialCiudadList = Optional.ofNullable(materialDto.getMaterialCiudadList())
					.orElseGet(Collections::emptyList).stream()
					.peek(x -> x.setIdMaterial(materialResponse.getIdMaterial()))
					.map(x -> materialCiudadMapper.materialCiudadDtoToMaterialCiudad(x)).collect(Collectors.toList());

			materialCiudadRepository.saveAll(materialCiudadList);

			return materialMapper.entityToDto(materialResponse);
		} else {
			MaterialDTO materialResponse = null;
			return materialResponse;
		}

	}
}
