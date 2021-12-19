package com.ufps.springboot.vigilancia.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "supervisor")
public class Supervisor {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cedula;
	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	private String nombre;
	
	private int edad;

}
