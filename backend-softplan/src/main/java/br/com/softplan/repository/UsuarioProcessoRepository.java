package br.com.softplan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.softplan.model.entity.UsuarioProcesso;

public interface UsuarioProcessoRepository extends JpaRepository<UsuarioProcesso, Long> {

	List<UsuarioProcesso> findByProcessoId(Long processoId);

	List<UsuarioProcesso> findByUsuarioId(Long usuarioId);

	void deleteByUsuarioId(Long usuarioId);
	
	List<UsuarioProcesso> findByUsuarioIdAndProcessoId(Long usuarioId, Long processoId);

	@Query("SELECT u FROM UsuarioProcesso u WHERE u.usuario.id = :usuarioId AND u.processo.dsParecer IS NULL ")
	List<UsuarioProcesso> findPedenteByUsuarioId(Long usuarioId);

}
