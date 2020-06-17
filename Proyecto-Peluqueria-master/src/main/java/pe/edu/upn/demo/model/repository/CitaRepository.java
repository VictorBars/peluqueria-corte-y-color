package pe.edu.upn.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo.model.entidades.Cita;


@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{

	@Query(value="SELECT * FROM cita "
			+ "WHERE fecha_cita LIKE '2019-11%' "
			+ "ORDER BY cod_servicio", nativeQuery=true) 
	List<Cita> fecha();
}
