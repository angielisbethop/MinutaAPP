package com.ufps.springboot.vigilancia.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.vigilancia.models.dao.IVigilanteDao;
import com.ufps.springboot.vigilancia.models.entities.Vigilante;

@Service
public class VigilanteServiceImpl implements IVigilanteService {
	
	@Autowired
	private IVigilanteDao vigilanteDao;

	@Override
	public void saveVigilante(Vigilante vigilante) {
		vigilanteDao.save(vigilante);
		
	}
	
	@Override
	public List<Vigilante> findAll() {
		return (List<Vigilante>)vigilanteDao.findAll();
	}

	@Override
	public void asignarSupervisor(Vigilante vigilante) {
		vigilanteDao.save(vigilante);
		
	}

	@Override
	public Vigilante getVigilante(String cedula) {
		return vigilanteDao.findById(cedula).orElse(null);
	}

	@Override
	public void deleteById(String cedula) {
		vigilanteDao.deleteById(cedula);
		
	}

	@Override
	public List<Vigilante> listAllBySupervisor(String supervisor) {
		return vigilanteDao.listAllBySupervisor(supervisor);
	}


}
