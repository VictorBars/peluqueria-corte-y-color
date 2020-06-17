package pe.edu.upn.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo.model.entidades.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

}
