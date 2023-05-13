package com.servicios.publicos.back.app.domain.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material")
public class Material implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_material")
	private int idMaterial;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "serial")
	private String serial;

	@Column(name = "numero_interno")
	private String numeroInterno;

	@Column(name = "precio")
	private double precio;

	@Column(name = "fecha_compra")
	private Date fechaCompra;

	@Column(name = "fecha_venta")
	private Date fechaVenta;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "material_ciudad", joinColumns = @JoinColumn(name = "id_material"), inverseJoinColumns = @JoinColumn(name = "id_ciudad"))
	private List<Ciudad> ciudades;

}
