package br.com.softplan.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.model.entity.Usuario;


public interface UserRepository extends JpaRepository<Usuario, Long> {

}
