package br.com.softplan.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.model.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
}