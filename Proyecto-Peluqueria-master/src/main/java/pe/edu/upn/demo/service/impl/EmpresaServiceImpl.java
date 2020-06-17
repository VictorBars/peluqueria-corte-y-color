package pe.edu.upn.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo.model.entidades.Empresa;
import pe.edu.upn.demo.model.repository.EmpresaRepository;
import pe.edu.upn.demo.service.EmpresaService;
@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Empresa> findAll() throws Exception {
		return empresaRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Empresa> findById(Integer id) throws Exception {
		return empresaRepository.findById(id);
	}
	@Transactional
	@Override
	public Empresa save(Empresa entity) throws Exception {
		return empresaRepository.save(entity);
	}
	@Transactional
	@Override
	public Empresa update(Empresa entity) throws Exception {
		return empresaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		 empresaRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		empresaRepository.deleteAll();
	}
	@Override
	public List<Empresa> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
