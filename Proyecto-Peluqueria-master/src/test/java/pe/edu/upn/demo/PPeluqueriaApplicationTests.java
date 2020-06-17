package pe.edu.upn.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.demo.model.entidades.Horario;
import pe.edu.upn.demo.model.entidades.Servicio;
import pe.edu.upn.demo.model.entidades.Trabajador;
import pe.edu.upn.demo.model.repository.HorarioRepository;
import pe.edu.upn.demo.model.repository.ServicioRepository;
import pe.edu.upn.demo.model.repository.TrabajadorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PPeluqueriaApplicationTests {

	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	
	@Test
	public void contextLoads() {
		
		servicioRepository.deleteAll();
		horarioRepository.deleteAll();
		trabajadorRepository.deleteAll();
		
		Servicio ser = new Servicio();
		ser.setCodigo(1);
		ser.setNombre("Corte Hombre");
		ser.setPrecio(12.00);
		ser.setDuracion("45 min");
		
	    ser = servicioRepository.save(ser);
	    
	    
	    //Horario 1
	    Horario hora = new Horario();
	    hora.setCodigo(1);
	    hora.setDescripcion("09:00 am");
	    hora = horarioRepository.save(hora);
	    
	    //Horario 2
	    Horario hora1 = new Horario();
	    hora1.setCodigo(2);
	    hora1.setDescripcion("10:00 am");
	    hora1 = horarioRepository.save(hora1);
	    
	    //Horario 3
	    Horario hora2 = new Horario();
	    hora2.setCodigo(3);
	    hora2.setDescripcion("08:00 pm");
	    hora2 = horarioRepository.save(hora2);
	    
	    //Horario 4
	    Horario hora3 = new Horario();
	    hora3.setCodigo(4);
	    hora3.setDescripcion("09:00 pm");
	    hora3 = horarioRepository.save(hora3);
	    
	    //Trabajador 1
	    Trabajador t1 = new Trabajador();
	    t1.setNombre("Vilma Aurora Lozano Vasquez");
	    t1.setSexo("F");
	    t1.setDireccion("Jr.Ica 3290");
	    t1.setDni("78562345");
	    t1.setTelefono("123456789");
	    t1 = trabajadorRepository.save(t1);
	    
	    //Trabajador 2
	    Trabajador t2 = new Trabajador();
	    t2.setNombre("Janet Rosa Lozano Ramirez");
	    t2.setSexo("F");
	    t2.setDireccion("Jr.Huanuco 3456");
	    t2.setDni("12345656");
	    t2.setTelefono("123457689");
	    t2 = trabajadorRepository.save(t2);
	    
	    //Trabajador 3
	    Trabajador t3 = new Trabajador();
	    t3.setNombre("Paola Jimena Talabera Riera");
	    t3.setSexo("F");
	    t3.setDireccion("Pacasmayo 3290");
	    t3.setDni("12342345");
	    t3.setTelefono("321456789");
	    t3 = trabajadorRepository.save(t3);
	    
	    //Trabajador 4
	    Trabajador t4 = new Trabajador();
	    t4.setNombre("Ivan Moreno Moreno ");
	    t4.setSexo("M");
	    t4.setDireccion("Jr.Ica 3290");
	    t4.setDni("78562455");
	    t4.setTelefono("123453459");
	    t4 = trabajadorRepository.save(t4);
	    
	    
	    //Grabar Servicio
	    servicioRepository.save(ser);
	    
	    //Grabar Horario
	    horarioRepository.save(hora);
	    horarioRepository.save(hora1);
	    horarioRepository.save(hora2);
	    horarioRepository.save(hora3);
	    
	    //Grabar Trabajador
	    trabajadorRepository.save(t1);
	    trabajadorRepository.save(t2);
	    trabajadorRepository.save(t3);
	    trabajadorRepository.save(t4);
	    
	    
	}

}
