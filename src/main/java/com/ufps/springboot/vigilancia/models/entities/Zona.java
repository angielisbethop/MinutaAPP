package com.ufps.springboot.vigilancia.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "zonas")
@Data
public class Zona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreEmpresa;
	
	
	private String direccion;

	private String responsable;
	
	private String contacto;
	
	
	private String telefono;
	
	
	@ManyToOne
	@JoinColumn(name = "supervisor")
	private Supervisor supervisor;

}
