package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "consulta_examen")
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {
	
	// [idConsulta(FK) idExamen(FK)] PK
	
	@Id
	private Consulta consulta;

	@Id
	private Examen examen;

	public Consulta getIdConsulta() {
		return consulta;
	}

	public void setIdConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

}
