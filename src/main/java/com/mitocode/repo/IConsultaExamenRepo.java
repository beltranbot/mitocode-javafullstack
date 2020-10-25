package com.mitocode.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.ConsultaExamen;

public interface IConsultaExamenRepo extends IGenericRepo<ConsultaExamen, Integer> {

	@Modifying
	@Query(value = "insert into consulta_examen(id_consulta, id_examen) values (:idConsulta, :idExamen)", nativeQuery = true)
	Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idExamen") Integer idExamen);
	
	

}
