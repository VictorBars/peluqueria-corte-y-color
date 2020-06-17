package pe.edu.upn.demo.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import pe.edu.upn.demo.service.CitaService;
import pe.edu.upn.demo.service.HorarioService;
import pe.edu.upn.demo.service.ServicioService;
import pe.edu.upn.demo.service.TarjetaService;
import pe.edu.upn.demo.service.TrabajadorService;

@Controller
@RequestMapping("/cita")
@SessionAttributes({ "servicio", "horario", "cita", "trabajador", "tarjeta" })
public class CitaController {

	@Autowired
	private CitaService citaService;

	@Autowired
	private ServicioService servicioService;

	@Autowired
	private HorarioService horarioService;

	@Autowired
	private TrabajadorService trabajadorService;

	@Autowired
	private TarjetaService tarjetaService;

	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cita> cita = citaService.findAll();
			model.addAttribute("citas", cita);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "/cita/inicio";
	}

	@GetMapping("/fecha")
	public String precio(Model model) {
		try {
			List<Cita> cita = citaService.fecha();
			model.addAttribute("citas", cita);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cita/fecha";
	}

	@GetMapping("/export/all")
	public ResponseEntity<InputStreamResource> exportAllData() throws Exception {
		ByteArrayInputStream stream = citaService.exportAllData();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=CitasRealizadas.xls");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}

	@GetMapping("/editc/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cita> optional = citaService.findById(id);
			if (optional.isPresent()) {

				List<Servicio> servicio = servicioService.findAll();
				model.addAttribute("servicio", servicio);

				List<Horario> horario = horarioService.findAll();
				model.addAttribute("horario", horario);

				List<Tarjeta> tarjeta = tarjetaService.findAll();
				model.addAttribute("tarjeta", tarjeta);

				List<Trabajador> trabajador = trabajadorService.findAll();
				model.addAttribute("trabajador", trabajador);
				optional.get().setEst_cita("si");
				model.addAttribute("cita", optional.get());
			} else {
				return "redirect:/cita";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "/cita/editc";
	}

	@GetMapping("/delc/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cita> cita = citaService.findById(id);
			if (cita.isPresent()) {
				citaService.deleteById(id);
			}
		} catch (Exception e) {

			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Cita> cita = citaService.findAll();
				model.addAttribute("cita", cita);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "/cita";
		}
		return "redirect:/cita";
	}

	@PostMapping("/savecita")
	public String saveservicio(@ModelAttribute("cita") Cita cita, Model model, SessionStatus status) {
		try {
			citaService.save(cita);
			status.setComplete();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cita";
	}
}
