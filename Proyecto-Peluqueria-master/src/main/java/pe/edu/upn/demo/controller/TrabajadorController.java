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

import pe.edu.upn.demo.model.entidades.Trabajador;
import pe.edu.upn.demo.service.TrabajadorService;

@Controller
@RequestMapping("/trabajador")
@SessionAttributes ("trabajador")
public class TrabajadorController {
 
	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Trabajador> trabajador = trabajadorService.findAll();
			model.addAttribute("trabajadores", trabajador );
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/trabajador/inicio";
	}
	
	@GetMapping("/registrot")
	public String registro(Model model) {
		Trabajador trabajador = new Trabajador();
		model.addAttribute("trabajador", trabajador);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/trabajador/registrot";
	}
	
	@GetMapping("/editt/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Trabajador> optional = trabajadorService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("trabajador", optional.get());
			} else {
				return "redirect:/trabajador";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/trabajador/editt";
	}
	
	@GetMapping("/delt/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Trabajador> trabajador = trabajadorService.findById(id);
			if(trabajador.isPresent()) {
				trabajadorService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Trabajador> trabajador = trabajadorService.findAll();
				model.addAttribute("trabajador", trabajador);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/trabajador";
		}
		return "redirect:/trabajador";
	}
	
	
	
	@PostMapping("/savetrabajador")
	public String saveservicio(@ModelAttribute("trabajador") Trabajador trabajador, 
			Model model, SessionStatus status) {
		try {
			trabajadorService.save(trabajador);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/trabajador";
	}
}
