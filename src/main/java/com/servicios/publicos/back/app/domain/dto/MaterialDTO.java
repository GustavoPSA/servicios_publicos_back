package com.servicios.publicos.back.app.domain.dto;

import java.util.Date;
import java.util.List;

import com.servicios.publicos.back.app.domain.models.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

	private int idMaterial;

	private String nombre;

	private String descripcion;

	private String tipo;

	private String serial;

	private String numeroInterno;

	private double precio;

	private Date fechaCompra;

	private Date fechaVenta;

	private Estado estado;

	private List<MaterialCiudadDTO> materialCiudadList;

}
