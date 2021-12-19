package com.ufps.springboot.vigilancia.models.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ufps.springboot.vigilancia.models.entities.Puesto;

public interface IPuestoDao extends JpaRepository<Puesto, Long> {
	
	@Query("SELECT p FROM Puesto p WHERE p.vigilante.usuario.username=?1")
	public List<Puesto> listAllByVigi(String vigilante);

}
