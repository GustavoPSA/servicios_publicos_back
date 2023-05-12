package com.servicios.publicos.back.app.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material_ciudad")
public class MaterialCiudad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_material_ciudad")
	private int idMaterialCiudad;

	@Column(name = "id_material")
	private int idMaterial;

	@Column(name = "id_ciudad")
	private int idCiudad;
}
