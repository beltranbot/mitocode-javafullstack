package com.mitocode.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.Consulta;

public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {

	// JPQL - Java Persistent Query Language
	@Query("FROM Consulta c WHERE c.paciente.dni = :dni OR c.paciente.nombres LIKE %:nombreCompleto%")
	List<Consulta> buscar(@Param("dni") String dni, @Param("nombreCompleto") String nombreCompleto);

	// BETWEEN
	@Query("FROM Consulta c WHERE c.fecha BETWEEN :fechaConsulta AND :fechaSgte")
	List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta,
			@Param("fechaSgte") LocalDateTime fechaSgte);
	
	@Query(value = "select * from fn_listarResumen();", nativeQuery = true)
	List<Object[]> listarResumen();
	
	// cantidad fecha
	// [1, "07/11/2020"]
	// [2, "14/11/2020"]
	// [3, "24/10/2020"]

}
