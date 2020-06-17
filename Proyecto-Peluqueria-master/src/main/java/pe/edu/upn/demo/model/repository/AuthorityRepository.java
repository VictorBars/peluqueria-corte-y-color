package pe.edu.upn.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo.model.entidades.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
