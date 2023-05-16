package com.servicios.publicos.back.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicios.publicos.back.app.domain.dto.EstadoDTO;
import com.servicios.publicos.back.app.domain.mapper.EstadoMapper;
import com.servicios.publicos.back.app.domain.models.Estado;
import com.servicios.publicos.back.app.exception.NotFoundException;
import com.servicios.publicos.back.app.repository.EstadoRepository;
import com.servicios.publicos.back.app.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EstadoMapper estadoMapper;

	@Override
	@Transactional(readOnly = true)
	public List<EstadoDTO> list() {

		List<Estado> estados = estadoRepository.findAll();

		if (estados.isEmpty()) {
			throw new NotFoundException("No se encontraron estados");
		}

		return estadoMapper.toListDTO(estados);
	}
}
