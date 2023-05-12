package com.servicios.publicos.back.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDTO {

	private int idCiudad;

	private String desCiudad;

	private int indActivo;
}
