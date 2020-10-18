package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	private Integer idRol;
	@Column(name = "nombre")
	private String nomber;
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNomber() {
		return nomber;
	}

	public void setNomber(String nomber) {
		this.nomber = nomber;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
