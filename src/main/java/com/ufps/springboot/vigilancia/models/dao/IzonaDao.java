package com.ufps.springboot.vigilancia.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ufps.springboot.vigilancia.models.entities.Zona;

public interface IzonaDao  extends JpaRepository<Zona, Long>{
	
	@Query("SELECT z FROM Zona z WHERE z.supervisor.usuario.username=?1")
	public List<Zona> listAllZonasAsig(String usrname);

}
