package com.ufps.springboot.vigilancia.models.services;

import java.util.List;

import com.ufps.springboot.vigilancia.models.entities.Supervisor;

public interface ISupervisorService {
	
	public void saveSupervisor(Supervisor supervisor);
	
	public List<Supervisor> findAll();
	
	public Supervisor getSupervisor(String cedula); 
	
	public void deleteById(String cedula);

}
