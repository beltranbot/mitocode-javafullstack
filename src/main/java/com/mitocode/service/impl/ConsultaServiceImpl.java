package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.model.Consulta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IConsultaExamenRepo;
import com.mitocode.repo.IConsultaRepo;
import com.mitocode.service.IConsultaService;

@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta, Integer> implements IConsultaService {

	@Autowired
	private IConsultaRepo repo;
	
	@Autowired
	private IConsultaExamenRepo ceRepo;

	@Override
	protected IGenericRepo<Consulta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Consulta registrarTransaccional(ConsultaListaExamenDTO dto) throws Exception {
		dto.getConsulta().getDetalleConsulta().forEach(detalle -> detalle.setConsulta(dto.getConsulta()));
		repo.save(dto.getConsulta());
		
		dto.getLstExamen().forEach(examen -> ceRepo.registrar(dto.getConsulta().getIdConsulta(), examen.getIdExamen()));
		return dto.getConsulta();
	}

}
