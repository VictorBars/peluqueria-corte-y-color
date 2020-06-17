package pe.edu.upn.demo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import pe.edu.upn.demo.model.entidades.Cita;

public interface CitaService extends CrudService<Cita, Integer>{
		
	List<Cita> fecha( ) throws Exception;
	
	ByteArrayInputStream exportAllData() throws Exception;
}
