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
@Table(name = "estado")
public class Estado {

	@Id
	@Column(name = "id_estado")
	private int idEstado;

	@Column(name = "des_estado")
	private String desEstado;

}
