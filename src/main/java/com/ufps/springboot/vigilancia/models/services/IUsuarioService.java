package com.ufps.springboot.vigilancia.models.services;


import java.util.List;

import com.ufps.springboot.vigilancia.models.entities.Rol;
import com.ufps.springboot.vigilancia.models.entities.Usuario;



public interface IUsuarioService {
	
	
	public void save(Usuario usuario);
	
	public List<Usuario> findAll();
	
	public void delete(Long id);
	
	public Usuario findById(Long id);
	
	public int cantidadUsuarios();
	
	//---------------------------------
	
	public List<Rol> findallRol();
	
	public void saveRol(Rol rol);
	
	public Rol findRolById(Long username);


}
