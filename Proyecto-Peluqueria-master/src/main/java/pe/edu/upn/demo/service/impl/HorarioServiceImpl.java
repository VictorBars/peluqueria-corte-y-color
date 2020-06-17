package pe.edu.upn.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo.model.entidades.Horario;
import pe.edu.upn.demo.model.repository.HorarioRepository;
import pe.edu.upn.demo.service.HorarioService;
	@Service
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	private HorarioRepository horariorepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Horario> findAll() throws Exception {
		return horariorepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Horario> findById(Integer id) throws Exception {
		return horariorepository.findById(id);
	}
	@Transactional
	@Override
	public Horario save(Horario entity) throws Exception {
		return horariorepository.save(entity);
	}
	@Transactional
	@Override
	public Horario update(Horario entity) throws Exception {
		return horariorepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		this.horariorepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		this.horariorepository.deleteAll();
	}
	@Override
	public List<Horario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
