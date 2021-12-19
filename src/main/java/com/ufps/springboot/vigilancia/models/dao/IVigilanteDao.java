package com.ufps.springboot.vigilancia.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ufps.springboot.vigilancia.models.entities.Vigilante;

public interface IVigilanteDao extends CrudRepository<Vigilante, String>{
	
	@Query("SELECT v FROM Vigilante v WHERE v.supervisor.usuario.username=?1")
	public List<Vigilante> listAllBySupervisor(String supervisor);



}
