package com.ufps.springboot.vigilancia.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.vigilancia.models.dao.IRolDao;
import com.ufps.springboot.vigilancia.models.dao.IUsuarioDao;
import com.ufps.springboot.vigilancia.models.entities.Rol;
import com.ufps.springboot.vigilancia.models.entities.Usuario;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IRolDao rolDao;
	
	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public void delete(Long id) {
		usuarioDao.deleteById(id);
		
	}


	@Override
	public void saveRol(Rol rol) {
		rolDao.save(rol);
	}

	

	@Override
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public List<Rol> findallRol() {
		return (List<Rol>)rolDao.findAll();
	}

	@Override
	public Rol findRolById(Long username) {
		
		return rolDao.findRolById(username);
	}

	@Override
	public int cantidadUsuarios() {
		return usuarioDao.cantidadUsuarios();
	}

	

	
}
