package com.servicios.publicos.back.app.domain.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@ManyToMany(mappedBy = "ciudades")
	private List<Material> materiales;
}
