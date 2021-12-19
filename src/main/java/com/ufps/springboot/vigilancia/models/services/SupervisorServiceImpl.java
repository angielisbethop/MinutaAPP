package com.ufps.springboot.vigilancia.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.vigilancia.models.dao.ISupervisorDao;
import com.ufps.springboot.vigilancia.models.entities.Supervisor;

@Service
public class SupervisorServiceImpl implements ISupervisorService {
	
	@Autowired
	private ISupervisorDao supervisorDao;

	@Override
	public void saveSupervisor(Supervisor supervisor) {
		supervisorDao.save(supervisor);
	}

	@Override
	public List<Supervisor> findAll() {
		return (List<Supervisor>)supervisorDao.findAll();
	}

	@Override
	public Supervisor getSupervisor(String cedula) {
		return supervisorDao.findById(cedula).orElse(null);
	}

	@Override
	public void deleteById(String cedula) {
		supervisorDao.deleteById(cedula);
		
	}

}
