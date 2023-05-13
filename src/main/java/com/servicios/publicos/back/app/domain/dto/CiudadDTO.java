package com.servicios.publicos.back.app.domain.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.servicios.publicos.back.app.domain.models.Material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDTO {

	@NotNull
	private int idCiudad;

	private String desCiudad;

	private int indActivo;

	private List<Material> materiales;
}
