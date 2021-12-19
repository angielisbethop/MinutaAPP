package com.ufps.springboot.vigilancia.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "vigilante")
public class Vigilante {
	
	@Id
	private String cedula;
	@ToString.Exclude
	@OneToOne()
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	private String nombre;
	
	private int edad;
	
	
	@ToString.Exclude
	@ManyToOne()
	@JoinColumn(name = "supervisor")
	private Supervisor supervisor;
	
	
}
