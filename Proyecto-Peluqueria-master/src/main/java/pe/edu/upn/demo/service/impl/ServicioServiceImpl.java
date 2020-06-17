package pe.edu.upn.demo.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo.model.entidades.Servicio;
import pe.edu.upn.demo.model.repository.ServicioRepository;
import pe.edu.upn.demo.service.ServicioService;
@Service
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioRepository serviciorepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Servicio> findAll() throws Exception {
		return serviciorepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Servicio> findById(Integer id) throws Exception {
		return serviciorepository.findById(id);
	}

	@Transactional
	@Override
	public Servicio save(Servicio entity) throws Exception {
		return serviciorepository.save(entity);
	}
	@Transactional
	@Override
	public Servicio update(Servicio entity) throws Exception {
		return serviciorepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		this.serviciorepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		this.serviciorepository.deleteAll();
	}
	@Override
	public List<Servicio> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
