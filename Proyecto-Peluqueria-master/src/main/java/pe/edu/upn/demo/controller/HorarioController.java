package pe.edu.upn.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.demo.model.entidades.Horario;

import pe.edu.upn.demo.service.HorarioService;

@Controller
@RequestMapping("/horario")
@SessionAttributes ("horario")
public class HorarioController {

	@Autowired
	private HorarioService horarioService;
	
	
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Horario> horario = horarioService.findAll();
			model.addAttribute("horarios", horario );
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/horario/inicio";
	}
	
	@GetMapping("/registroh")
	public String registro(Model model) {
		Horario horario = new Horario();
		model.addAttribute("horario", horario);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/horario/registroh";
	}
	
	@GetMapping("/edith/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Horario> optional = horarioService.findById(id);
			if (optional.isPresent()) {
				
				
				model.addAttribute("horario", optional.get());
			} else {
				return "redirect:/horario";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/horario/edith";
	}
	 
	@GetMapping("/delh/{id}") 
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Horario> horario = horarioService.findById(id);
			if(horario.isPresent()) {
				horarioService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Horario> horario = horarioService.findAll();
				model.addAttribute("horario", horario);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/horario";
		}
		return "redirect:/horario";
	}
	
	
	@PostMapping("/savehorario")
	public String saveservicio(@ModelAttribute("horario") Horario horario, 
			Model model, SessionStatus status) {
		try {
			horarioService.save(horario);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/horario";
	}
}
