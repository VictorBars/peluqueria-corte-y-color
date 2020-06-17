package pe.edu.upn.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.demo.model.entidades.Empresa;
import pe.edu.upn.demo.model.entidades.Tarjeta;
import pe.edu.upn.demo.model.entidades.Usuario;
import pe.edu.upn.demo.service.EmpresaService;
import pe.edu.upn.demo.service.TarjetaService;
import pe.edu.upn.demo.service.UsuarioService;

@Controller
@RequestMapping("/tarjeta")
@SessionAttributes({ "tarjeta", "empresa", "usuario" })
public class TarjetaController {

	@Autowired
	private TarjetaService tarjetaService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Tarjeta> tarjeta = tarjetaService.findAll();
			model.addAttribute("tarjetas", tarjeta );
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/tarjeta/inicio";
	}
	
	
	@GetMapping("/registrotar")
	public String registro(Model model) {
		Tarjeta tarjeta = new Tarjeta();
		model.addAttribute("tarjeta", tarjeta);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		try {
			
			Optional<Usuario> optional = usuarioService.findByUsername(username);
			
			if(optional.isPresent()) {
			
			model.addAttribute("usuario", optional.get());
			tarjeta.setUsuario(optional.get());
			
			List<Empresa> empresa = empresaService.findAll();
			model.addAttribute("empresas", empresa );
			
			
		}
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/tarjeta/registrotar";
	}
	
	@PostMapping("/savetarjeta")
	public String saveservicio(@ModelAttribute("tarjeta") Tarjeta tarjeta, 
			Model model, SessionStatus status) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		try {
			Optional<Usuario> optional = usuarioService.findByUsername(username);
			if(optional.isPresent()) {
				model.addAttribute("usuario", optional.get());
			}
			tarjetaService.save(tarjeta);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/servicio";
	}
	
	
	
}
