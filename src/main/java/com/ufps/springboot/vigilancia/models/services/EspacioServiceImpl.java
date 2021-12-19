package com.ufps.springboot.vigilancia.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufps.springboot.vigilancia.models.dao.IPuestoDao;
import com.ufps.springboot.vigilancia.models.dao.IzonaDao;
import com.ufps.springboot.vigilancia.models.entities.Puesto;
import com.ufps.springboot.vigilancia.models.entities.Zona;


@Service
public class EspacioServiceImpl implements IEspacioService {
	
	@Autowired
	private IzonaDao zonaDao;
	
	@Autowired
	private IPuestoDao puestoDao;

	@Override
	public void saveZona(Zona zona) {
		zonaDao.save(zona);

	}

	@Override
	public void savePuesto(Puesto puesto) {
		puestoDao.save(puesto);

	}

	@Override
	public List<Zona> listAll() {
		return zonaDao.findAll();
	}

	@Override
	public List<Zona> listByUsername(String username) {
		return zonaDao.listAllZonasAsig(username);
	}

	@Override
	public Zona findById(Long id) {
		return zonaDao.findById(id).orElse(null);
	}

	@Override
	public List<Puesto> listAllPuestoVigilante(String vigilante) {
		
		return puestoDao.listAllByVigi(vigilante);
	}

}
