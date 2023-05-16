package com.servicios.publicos.back.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicios.publicos.back.app.domain.dto.CiudadDTO;
import com.servicios.publicos.back.app.domain.mapper.CiudadMapper;
import com.servicios.publicos.back.app.domain.models.Ciudad;
import com.servicios.publicos.back.app.exception.NotFoundException;
import com.servicios.publicos.back.app.repository.CiudadRepository;
import com.servicios.publicos.back.app.service.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;

	@Autowired
	private CiudadMapper ciudadMapper;

	@Override
	@Transactional(readOnly = true)
	public List<CiudadDTO> list() {

		List<Ciudad> ciudades = ciudadRepository.findAll();

		if (ciudades.isEmpty()) {
			throw new NotFoundException("No se encontraron ciudades");
		}

		return ciudadMapper.toListDTO(ciudades);
	}
}
