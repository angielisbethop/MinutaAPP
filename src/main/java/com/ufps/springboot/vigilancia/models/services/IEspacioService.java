package com.ufps.springboot.vigilancia.models.services;

import java.util.List;

import com.ufps.springboot.vigilancia.models.entities.Puesto;
import com.ufps.springboot.vigilancia.models.entities.Zona;

public interface IEspacioService {
	
	public void saveZona(Zona zona);
	
	public List<Zona> listAll();
	
	public List<Zona> listByUsername(String username);
	
	public Zona findById(Long id);
	
	
	
	
	
	public void savePuesto(Puesto puesto);
	
	public List<Puesto> listAllPuestoVigilante(String vigilante);

}
