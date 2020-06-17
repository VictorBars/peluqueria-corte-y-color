package pe.edu.upn.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo.model.entidades.Tarjeta;
import pe.edu.upn.demo.model.repository.TarjetaRepository;
import pe.edu.upn.demo.service.TarjetaService;

@Service
public class TarjetaServiceImpl implements TarjetaService {

	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Tarjeta> findAll() throws Exception {
		return tarjetaRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Tarjeta> findById(Integer id) throws Exception {
		return tarjetaRepository.findById(id);
	}
	@Transactional
	@Override
	public Tarjeta save(Tarjeta entity) throws Exception {
		return tarjetaRepository.save(entity);
	}
	@Transactional
	@Override
	public Tarjeta update(Tarjeta entity) throws Exception {
		return tarjetaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		this.tarjetaRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		this.tarjetaRepository.deleteAll();
	}
	@Override
	public List<Tarjeta> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
