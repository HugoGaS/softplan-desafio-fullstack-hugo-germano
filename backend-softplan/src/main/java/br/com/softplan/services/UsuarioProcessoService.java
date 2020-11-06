package br.com.softplan.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.model.dto.UsuarioDTO;
import br.com.softplan.model.entity.Processo;
import br.com.softplan.model.entity.Usuario;
import br.com.softplan.model.entity.UsuarioProcesso;
import br.com.softplan.repository.UsuarioProcessoRepository;

@Service
public class UsuarioProcessoService {

	@Autowired
	private UsuarioProcessoRepository usuarioProcessoRepository;

	public List<UsuarioProcesso> findAll() {
		return usuarioProcessoRepository.findAll();
	}

	public List<UsuarioProcesso> findByUsuarioId(Long id) {
		return usuarioProcessoRepository.findByUsuarioId(id);
	}

	public List<UsuarioProcesso> findByProcessoId(Long id) {
		return usuarioProcessoRepository.findByProcessoId(id);
	}

	public List<UsuarioProcesso> findPedenteByUsuarioId(Long id) {
		return usuarioProcessoRepository.findPedenteByUsuarioId(id);
	}

	public void deleteByUsuarioId(Long usuarioId) {
		usuarioProcessoRepository.deleteByUsuarioId(usuarioId);
	}

	@Transactional
	public void atribuir(Processo processo, UsuarioDTO usuarioDTO) {
		if (usuarioProcessoRepository.findByUsuarioIdAndProcessoId(usuarioDTO.getId(), processo.getId()).isEmpty()) {
			UsuarioProcesso novoUsuarioProcesso = new UsuarioProcesso(processo, new Usuario(usuarioDTO));
			usuarioProcessoRepository.save(novoUsuarioProcesso);
		}
	}

}
