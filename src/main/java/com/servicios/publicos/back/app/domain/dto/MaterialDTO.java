package com.servicios.publicos.back.app.domain.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

	private int idMaterial;

	@NotBlank(message = "Nombre {campoRequerido}")
	private String nombre;

	@NotBlank(message = "Descripcion {campoRequerido}")
	private String descripcion;

	@NotBlank(message = "Tipo {campoRequerido}")
	private String tipo;

	@NotBlank(message = "Serial {campoRequerido}")
	private String serial;

	@NotBlank(message = "Numero Interno {campoRequerido}")
	private String numeroInterno;

	@DecimalMin(value = "0.0", inclusive = true, message = "Precio {campoValor}")
	private double precio;

	@NotNull(message = "Fecha Compra {campoFecha}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCompra;

	@NotNull(message = "Fecha Venta {campoFecha}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaVenta;

	@Valid
	@NotNull(message = "estado {campoRequerido}")
	private EstadoDTO estado;

	@NotEmpty(message = "ciudades {campoRequerido}")
	@Valid
	private List<CiudadDTO> ciudades;

}
