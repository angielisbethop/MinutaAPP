package com.ufps.springboot.vigilancia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufps.springboot.vigilancia.models.entities.Puesto;
import com.ufps.springboot.vigilancia.models.entities.Supervisor;
import com.ufps.springboot.vigilancia.models.entities.Vigilante;
import com.ufps.springboot.vigilancia.models.entities.Zona;
import com.ufps.springboot.vigilancia.models.services.IEspacioService;
import com.ufps.springboot.vigilancia.models.services.ISupervisorService;
import com.ufps.springboot.vigilancia.models.services.IVigilanteService;

@Controller
public class EspacioController {
	
	@Autowired 
	private IEspacioService espacioService;
	
	@Autowired
	private ISupervisorService supervisorService;
	
	@Autowired
	private IVigilanteService vigilanteService;
	
	
	@GetMapping("crearZona")
	public String crearZona(Model model) {
		List<Supervisor> supervisores = supervisorService.findAll();
		model.addAttribute("supervisores", supervisores);
		model.addAttribute("zona", new Zona());
		
		return "regZona";
		
	}
	
	@PostMapping("regZona")
	public String regZona(Zona zona, @RequestParam(name = "super") String cedula,  Model model, RedirectAttributes flash) {
		
		Supervisor supervisor = supervisorService.getSupervisor(cedula);
		zona.setSupervisor(supervisor);
		espacioService.saveZona(zona);
		flash.addFlashAttribute("success", "Espacio registrado y supervisor asugnado");
		
		return "redirect:/listZona";
		
	}
	
	@GetMapping("listZona")
	public String ListZonas(Model model) {
		
		List<Zona> zonas = espacioService.listAll();
		model.addAttribute("zonas", zonas);
		return "listZona";
	}
	
	
	@GetMapping("crearPuesto/{id}")
	public String crearPuesto(@PathVariable(name = "id") Long id,  Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		List<Vigilante> vigilantes = vigilanteService.listAllBySupervisor(userName);
		
		
		
		model.addAttribute("zona", id);
		model.addAttribute("vigilantes", vigilantes);
		model.addAttribute("puesto", new Puesto());
		
		return "regPuesto";
		
	}
	
	
	@PostMapping("regPuesto")
	public String regPuesto(Puesto puesto, @RequestParam(name = "vigi") String cedula,@RequestParam(name = "zona") Long id, Model dodel, RedirectAttributes flash) {
		
		Zona zona = espacioService.findById(id);
		Vigilante vigilante  = vigilanteService.getVigilante(cedula);
		puesto.setVigilante(vigilante);
		puesto.setZona(zona);
		espacioService.savePuesto(puesto);
		flash.addFlashAttribute("success", "Puesto Creado y Asignado Con Exito");

		return "redirect:/listEspaciosAsig";
	}
	
	
	
	
	
	

}
