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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.demo.model.entidades.Cita;
import pe.edu.upn.demo.model.entidades.Horario;
import pe.edu.upn.demo.model.entidades.Servicio;
import pe.edu.upn.demo.model.entidades.Tarjeta;
import pe.edu.upn.demo.model.entidades.Trabajador;
import pe.edu.upn.demo.model.entidades.Usuario;
import pe.edu.upn.demo.service.CitaService;
import pe.edu.upn.demo.service.HorarioService;
import pe.edu.upn.demo.service.ServicioService;
import pe.edu.upn.demo.service.TarjetaService;
import pe.edu.upn.demo.service.TrabajadorService;
import pe.edu.upn.demo.service.UsuarioService;
import pe.edu.upn.demo.service.impl.NotificacionServiceImpl;

@Controller
@RequestMapping("/servicio")
@SessionAttributes({ "servicio", "horario", "cita", "trabajador" ,"usuario" ,"tarjeta"}) 
public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@Autowired
	private HorarioService horarioService;
 
	@Autowired
	private CitaService citaService;

	@Autowired
	private TrabajadorService trabajadorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TarjetaService tarjetaService;
	
	@Autowired
	NotificacionServiceImpl notificacionServiceImpl;

	@GetMapping
	public String inicio(Model model) {
		try {
			List<Servicio> servicios = servicioService.findAll();
			model.addAttribute("servicios", servicios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/servicio/inicio";
	}

	@GetMapping("/nuevoservicio")
	public String nuevo(Model model) {
		
		try {
			List<Servicio> servicios = servicioService.findAll();
			model.addAttribute("servicios", servicios);
		} catch (Exception e) {

		}
		return "/servicio/nuevoservicio";
	}
	
	
	@GetMapping("/registros")
	public String registro(Model model) {
		Servicio servicio = new Servicio();
		model.addAttribute("servicio", servicio);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/servicio/registros";
	}
	
	@GetMapping("/edits/{id}")
	public String editars(@PathVariable("id") int id, Model model) {
		try {
			Optional<Servicio> optional = servicioService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("servicio", optional.get());
			} else {
				return "redirect:/servicio";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/servicio/edits";
	}
	
	
	@GetMapping("/dels/{id}")
	public String eliminars(@PathVariable("id") int id, Model model) {
		try {
			Optional<Servicio> servicio = servicioService.findById(id);
			if(servicio.isPresent()) {
				servicioService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Servicio> servicio = servicioService.findAll();
				model.addAttribute("servicio", servicio);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/servicio";
		}
		return "redirect:/servicio/nuevoservicio";
	}
	
	@PostMapping("/saveservicio")
	public String saveservicio(@ModelAttribute("servicio") Servicio servicio, 
			Model model, SessionStatus status) {
		try {
			servicioService.save(servicio);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/servicio/nuevoservicio";
	}
	
	

	@GetMapping("/info/{codigo}")
	private String info(@PathVariable("codigo") int codigo, Model model , Model model1) {
		
		Cita cita = new Cita();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
	
		try {

			Optional<Servicio> servicio = servicioService.findById(codigo);
			Optional<Usuario> optional = usuarioService.findByUsername(username);
			if (servicio.isPresent()) {
				
				if(optional.isPresent()) {

					List<Horario> horario = horarioService.findAll();
					model.addAttribute("horario", horario);

					List<Trabajador> trabajador = trabajadorService.findAll();
					model.addAttribute("trabajador", trabajador);

					List<Tarjeta> tarjeta = tarjetaService.findAll();
					model.addAttribute("tarjeta",tarjeta);
					
					model.addAttribute("usuario", optional.get());
					cita.setUsuario(optional.get());
					
					model.addAttribute("servicio", servicio.get());
					cita.setServicio(servicio.get());
					
					model.addAttribute("cita", cita);
				}
				
				
			} else {
				return "redirect:/servicio/inicio";
			}
		} catch (Exception e) {

		}
		return "/servicio/info";
		
	}
	
	@PostMapping("/saveedit")
	private String Confirmar(@ModelAttribute("cita") Cita cita, SessionStatus status , Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		try {
			
			Optional<Usuario> optional = usuarioService.findByUsername(username);
			
			if(optional.isPresent()) {
				model.addAttribute("usuario", optional.get());
				
			}
			
			citaService.save(cita);
			notificacionServiceImpl.sendNotificacionCita(optional.get(), cita);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/servicio";
		
	}
	

	@PostMapping("/save")
	private String save(@ModelAttribute("cita") Cita cita, SessionStatus status , Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		try {
			
			Optional<Usuario> optional = usuarioService.findByUsername(username);
			
			if(optional.isPresent()) {
				model.addAttribute("usuario", optional.get());
				
			}
			
			citaService.save(cita);
			status.setComplete();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/servicio";
		
	}
	

	
	

}
