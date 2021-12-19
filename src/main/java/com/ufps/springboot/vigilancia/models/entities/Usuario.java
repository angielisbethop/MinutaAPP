package com.ufps.springboot.vigilancia.models.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "users")
@Data
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username",unique = true, length = 30)
	private String username;
	@Column(name = "password", length = 60)
	private String password;
	
	private Boolean enable;
	@ToString.Exclude
	@OneToMany(mappedBy = "usuario",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Rol> roles;
}