package com.servicios.publicos.back.app.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.servicios.publicos.back.app.domain.dto.MaterialDTO;
import com.servicios.publicos.back.app.domain.models.Material;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

	Material dtoToEntity(MaterialDTO materialDTO);

	MaterialDTO entityToDto(Material material);

	List<MaterialDTO> toListDTO(List<Material> materiales);

}
