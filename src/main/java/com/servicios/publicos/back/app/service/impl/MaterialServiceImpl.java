package com.servicios.publicos.back.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Predicate;
import com.servicios.publicos.back.app.domain.dto.MaterialDTO;
import com.servicios.publicos.back.app.domain.mapper.MaterialMapper;
import com.servicios.publicos.back.app.domain.models.Material;
import com.servicios.publicos.back.app.exception.BackendException;
import com.servicios.publicos.back.app.exception.NotFoundException;
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
	public List<MaterialDTO> listar(Predicate predicate) {

		List<Material> materiales = (List<Material>) materialRepository.findAll(predicate);

		if (materiales.isEmpty()) {
			throw new NotFoundException("No se encontraron resultados");
		}

		return materialMapper.toListDTO(materiales);
	}

	@Override
	@Transactional(readOnly = true)
	public MaterialDTO listarId(int idMaterial) {
		// TODO Auto-generated method stub
		Optional<Material> materialOptional = materialRepository.findById(idMaterial);

		if (!materialOptional.isPresent()) {
			throw new NotFoundException("No se encontraro el material con ID: " + idMaterial);
		}

		return materialMapper.entityToDto(materialOptional.get());
	}

	@Override
	@Transactional(readOnly = false)
	public MaterialDTO add(MaterialDTO materialDto) {

		validarFechas(materialDto);
		// TODO Auto-generated method stub
		return materialMapper.entityToDto(materialRepository.save(materialMapper.dtoToEntity(materialDto)));
	}

	@Transactional
	@Override
	public MaterialDTO edit(MaterialDTO materialDto) {
		// TODO Auto-generated method stub

		validarFechas(materialDto);

		if (!materialRepository.existsById(materialDto.getIdMaterial())) {
			throw new NotFoundException("No se encontraro el material con ID: " + materialDto.getIdMaterial());
		}

		return materialMapper.entityToDto(materialRepository.save(materialMapper.dtoToEntity(materialDto)));

	}

	private void validarFechas(MaterialDTO materialDto) {

		if (materialDto.getFechaCompra().compareTo(materialDto.getFechaVenta()) > 0) {
			throw new BackendException("La fecha de Compra no debe ser mayor a la fecha de Venta");
		}
	}
}
