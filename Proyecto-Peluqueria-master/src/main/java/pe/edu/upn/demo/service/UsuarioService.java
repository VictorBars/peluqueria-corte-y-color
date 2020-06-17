package pe.edu.upn.demo.service;

import java.util.Optional;

import pe.edu.upn.demo.model.entidades.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	
	Optional<Usuario> findByUsername(String username) throws Exception;
}
