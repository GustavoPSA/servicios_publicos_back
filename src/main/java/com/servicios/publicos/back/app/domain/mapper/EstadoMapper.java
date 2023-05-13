package com.servicios.publicos.back.app.domain.mapper;

import org.mapstruct.Mapper;

import com.servicios.publicos.back.app.domain.dto.EstadoDTO;
import com.servicios.publicos.back.app.domain.models.Estado;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

	Estado dtoToEntity(EstadoDTO estadoDTO);

	EstadoDTO entityToDto(Estado estado);
}
