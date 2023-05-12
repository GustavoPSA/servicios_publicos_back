package com.servicios.publicos.back.app.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ciudad")
public class Ciudad {

	@Id
	@Column(name = "id_ciudad")
	private int idCiudad;

	@Column(name = "des_ciudad")
	private String desCiudad;

	@Column(name = "ind_activo")
	private int indActivo;
}
