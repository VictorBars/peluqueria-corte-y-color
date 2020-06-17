package pe.edu.upn.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo.model.entidades.Trabajador;
import pe.edu.upn.demo.model.repository.TrabajadorRepository;
import pe.edu.upn.demo.service.TrabajadorService;
@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Trabajador> findAll() throws Exception {
		return trabajadorRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Trabajador> findById(Integer id) throws Exception {
		return trabajadorRepository.findById(id);
	}
	@Transactional
	@Override
	public Trabajador save(Trabajador entity) throws Exception {
		return trabajadorRepository.save(entity);
	}
	@Transactional
	@Override
	public Trabajador update(Trabajador entity) throws Exception {
		return trabajadorRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		trabajadorRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		trabajadorRepository.deleteAll();
	}
	@Override
	public List<Trabajador> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
