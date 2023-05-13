package com.servicios.publicos.back.app.domain.mapper;

import org.mapstruct.Mapper;

import com.servicios.publicos.back.app.domain.dto.CiudadDTO;
import com.servicios.publicos.back.app.domain.models.Ciudad;

@Mapper(componentModel = "spring")
public interface CiudadMapper {

	Ciudad dtoToEntity(CiudadDTO ciudadDTO);

	CiudadDTO entityToDto(Ciudad ciudad);
}
