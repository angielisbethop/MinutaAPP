package com.ufps.springboot.vigilancia.models.services;

import java.util.List;

import com.ufps.springboot.vigilancia.models.entities.Vigilante;

public interface IVigilanteService {
	
	public void saveVigilante(Vigilante vigilante);
	
	public List<Vigilante> findAll();
	
	public void asignarSupervisor(Vigilante vigilante);
	
	public Vigilante getVigilante(String cedula); 
	
	public void deleteById(String cedula);
	
	
	public List<Vigilante> listAllBySupervisor(String supervisor);
	

}
