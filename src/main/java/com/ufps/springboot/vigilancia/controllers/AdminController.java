package com.ufps.springboot.vigilancia.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ufps.springboot.vigilancia.models.entities.Rol;
import com.ufps.springboot.vigilancia.models.entities.Supervisor;
import com.ufps.springboot.vigilancia.models.entities.Vigilante;
import com.ufps.springboot.vigilancia.models.services.ISupervisorService;
import com.ufps.springboot.vigilancia.models.services.IUsuarioService;
import com.ufps.springboot.vigilancia.models.services.IVigilanteService;



@Controller
public class AdminController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ISupervisorService supervisorService;
	
	@Autowired
	private IVigilanteService vigilanteService;
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		
		return "index";
	}
	
	
	
	@GetMapping(value = "/crearSupervisor")
	public String crearUsuario(Model model) {
		model.addAttribute("supervisor",new Supervisor());
		return "regSupervisor";
	}

	@PostMapping(value = "/regSupervisor")
	public String regSupervisor(Supervisor supervisor, @RequestParam(value = "password2") String pass, Model model, RedirectAttributes flash) {

		Rol rolEdit = usuarioService.findRolById(supervisor.getUsuario().getId());
		if(supervisor.getUsuario().getPassword().equals(pass)) {
			supervisor.getUsuario().setEnable(true);
			Rol roles = new Rol();
			String bcryptPassword = passwordEncoder.encode(supervisor.getUsuario().getPassword());
			roles.setAuthority("ROLE_SUPERVISOR");
			roles.setUsuario(supervisor.getUsuario());
			supervisor.getUsuario().setPassword(bcryptPassword);
			usuarioService.save(supervisor.getUsuario());
			supervisorService.saveSupervisor(supervisor);
			if (rolEdit!=null) {
				rolEdit.setAuthority("ROLE_SUPERVISOR");
				usuarioService.saveRol(rolEdit);
				return "redirect:/listSupervisor";
				
			}
			usuarioService.saveRol(roles);
		
			flash.addFlashAttribute("success", "Usuario "+supervisor.getUsuario().getUsername()+" Registrado - ROL: SUPERVISOR");
			return "redirect:/listSupervisor";
			
		
		}else {
			flash.addFlashAttribute("error", "Las Contraseñas no coinciden");
			return "redirect:/crearSupervisor";
			
		}
	
	}
	
	
	@GetMapping(value = "/crearVigilante")
	public String crearVigilante(Model model) {
		model.addAttribute("vigilante",new Vigilante());
		return "regVigilante";
	}
	
	@PostMapping(value = "/regVigilante")
	public String regVigilante(Vigilante vigilante, @RequestParam(value = "password2") String pass, Model model, RedirectAttributes flash) {

		Rol rolEdit = usuarioService.findRolById(vigilante.getUsuario().getId());
		if(vigilante.getUsuario().getPassword().equals(pass)) {
			vigilante.getUsuario().setEnable(true);
			Rol roles = new Rol();
			String bcryptPassword = passwordEncoder.encode(vigilante.getUsuario().getPassword());
			roles.setAuthority("ROLE_VIGILANTE");
			roles.setUsuario(vigilante.getUsuario());
			vigilante.getUsuario().setPassword(bcryptPassword);
			usuarioService.save(vigilante.getUsuario());
			vigilanteService.saveVigilante(vigilante);
			if (rolEdit!=null) {
				rolEdit.setAuthority("ROLE_VIGILANTE");
				usuarioService.saveRol(rolEdit);
				return "redirect:/listVigilante";
				
			}
			usuarioService.saveRol(roles);
		
			flash.addFlashAttribute("success", "Usuario "+vigilante.getUsuario().getUsername()+" Registrado - ROL: VIGILANTE");
			return "redirect:/listVigilante";
			
		
		}else {
			flash.addFlashAttribute("error", "Las Contraseñas no coinciden");
			return "redirect:/crearVigilante";
			
		}
	
	}
	
	
	@GetMapping(value = "/listSupervisor")
	public String listarSupervisor(Model model) {
		List<Supervisor> supervisores = supervisorService.findAll();
		model.addAttribute("supervisores", supervisores);
		//System.out.println("prueba ------ Roles"+ usuarios.get(0).getRoles());
		
		return "listSupervisor";
	}
	
	

	@GetMapping(value = "/listVigilante")
	public String listarVigilantes(Model model) {
		List<Vigilante> vigilantes = vigilanteService.findAll();
		model.addAttribute("vigilantes", vigilantes);
	
		return "listVigilante";
	}
	
	
	@GetMapping("asignar/{id}")
	public String asignar(@PathVariable(name = "id") String cedula, Model model) {
		
		List<Supervisor> supervisores = supervisorService.findAll();
		Vigilante vigilante= vigilanteService.getVigilante(cedula);
		model.addAttribute("vigilante", vigilante);
		model.addAttribute("supervisores", supervisores);
		
		return "asignarSupervisor";
		
	}
	
	@PostMapping("asignarSupervisor")
	public String asignarp(Vigilante vigilante, @RequestParam(name = "supervisorSelect") String cedula, Model model, RedirectAttributes flash) {
		
		Supervisor supervisor = supervisorService.getSupervisor(cedula);
		supervisor.setCedula(cedula);
		vigilante.setSupervisor(supervisor);
		vigilanteService.saveVigilante(vigilante);
		flash.addFlashAttribute("success", "Supervisor Asignado");

		return "redirect:/listVigilante";
		
	}
	
	@GetMapping(value = "eliminarSupervisor/{id}")
	public String eliminarSupervisor(@PathVariable(value = "id") String cedula, RedirectAttributes flash) {
		
			supervisorService.deleteById(cedula);
			flash.addFlashAttribute("success", "Se ha Eliminado con Exito");

		return "redirect:/listSupervisor";
	}
	
	@GetMapping(value = "eliminarVigilante/{id}")
	public String eliminarViginlante(@PathVariable(value = "id") String cedula, RedirectAttributes flash) {
		
			vigilanteService.deleteById(cedula);
			flash.addFlashAttribute("success", "Se ha Eliminado con Exito");

		return "redirect:/listVigilante";
	}
	
	@GetMapping(value = "editarSupervisor/{id}")
	public String editarSupervisor(@PathVariable(value = "id") String cedula, Model model, RedirectAttributes flash) {
		
			Supervisor supervisor = supervisorService.getSupervisor(cedula);
			if (supervisor == null) {
				flash.addFlashAttribute("error", "El supervisor no existe en la BD");
				return "redirect:/listSupervisor";

			}

		model.addAttribute("supervisor", supervisor);

		return "regSupervisor";
	}
	
	@GetMapping(value = "editarVigilante/{id}")
	public String editarVigilante(@PathVariable(value = "id") String cedula, Model model, RedirectAttributes flash) {
		
			Vigilante vigilante = vigilanteService.getVigilante(cedula);
			if (vigilante == null) {
				flash.addFlashAttribute("error", "El vigilante no existe en la BD");
				return "redirect:/listVigilante";

			}

		model.addAttribute("vigilante", vigilante);

		return "regVigilante";
	}
}
