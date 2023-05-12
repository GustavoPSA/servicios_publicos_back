package com.servicios.publicos.back.app.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.servicios.publicos.back.app.domain.dto.MaterialCiudadDTO;
import com.servicios.publicos.back.app.domain.models.MaterialCiudad;

@Named("MaterialCiudadMapper")
@Mapper(componentModel = "spring")
public interface MaterialCiudadMapper {

	MaterialCiudad materialCiudadDtoToMaterialCiudad(MaterialCiudadDTO materialCiudadDTO);

	MaterialCiudadDTO materialCiudadToMaterialCiudadDTO(MaterialCiudad materialCiudad);

	// @AfterMapping
	// static void ignoreMaterial(MaterialCiudad materialCiudad, @MappingTarget
	// MaterialCiudadDTO materialCiudadDto) {
	// materialCiudadDto.getMaterial().setMaterialCiudadList(null);
	// }

	// @Named("toDtoWithoutFather")
	// @Mappings({ @Mapping(target = "material", expression = "java(null)") })
	// MaterialCiudadDTO toDtoWithoutFather(MaterialCiudad materialCiudad);
}
