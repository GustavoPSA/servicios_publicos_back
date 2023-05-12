package com.servicios.publicos.back.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialCiudadDTO {

	private int idMaterialCiudad;

	private int idMaterial;

	private int idCiudad;

}
