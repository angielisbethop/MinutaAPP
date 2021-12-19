package com.ufps.springboot.vigilancia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ufps.springboot.vigilancia.models.entities.Puesto;
import com.ufps.springboot.vigilancia.models.entities.Vigilante;
import com.ufps.springboot.vigilancia.models.services.IEspacioService;

@Controller
public class VigilanteController {
	
	@Autowired
	private IEspacioService espacioService;
	
	
	
	@GetMapping("listPuestoAsig")
	public String ListPuestosAsig(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		List<Puesto> puestos = espacioService.listAllPuestoVigilante(userName);
		model.addAttribute("puestos", puestos);
		return "listPuestoAsig";
	}
	

}
