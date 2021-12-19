package com.ufps.springboot.vigilancia.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "puesto")
@Data
public class Puesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String ubicacion;
	
	@ManyToOne
	@JoinColumn(name = "zona")
	private Zona zona;
	
	@OneToOne
	@JoinColumn(name = "vigilante")
	private Vigilante vigilante;

}
