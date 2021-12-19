package com.ufps.springboot.vigilancia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ufps.springboot.vigilancia.models.entities.Vigilante;
import com.ufps.springboot.vigilancia.models.entities.Zona;
import com.ufps.springboot.vigilancia.models.services.IEspacioService;
import com.ufps.springboot.vigilancia.models.services.IVigilanteService;

@Controller
public class SupervisorController {
	
	@Autowired 
	private IEspacioService espacioService;
	
	@Autowired
	private IVigilanteService vigilanteService;
	
	
	
	@GetMapping("listEspaciosAsig")
	public String ListZonasAsig(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		List<Zona> zonas = espacioService.listByUsername(userName);
		model.addAttribute("zonas", zonas);
		return "listZonaAsig";
	}
	
	
	@GetMapping("listVigilantesAsig")
	public String ListVigilantesAsig(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		List<Vigilante> vigilantes = vigilanteService.listAllBySupervisor(userName);
		model.addAttribute("vigilantes", vigilantes);
		return "listVigilanteAsig";
	}
	
	

}
