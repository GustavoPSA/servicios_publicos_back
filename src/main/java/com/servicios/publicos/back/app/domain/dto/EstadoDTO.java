package com.servicios.publicos.back.app.domain.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDTO {

	@NotNull
	private int idEstado;

	private String desEstado;
}
