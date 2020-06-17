package pe.edu.upn.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo.model.entidades.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}
