package br.com.softplan.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.softplan.enums.Cargos;
import br.com.softplan.exception.EmailExistenteException;
import br.com.softplan.model.dto.UsuarioDTO;
import br.com.softplan.model.entity.Usuario;
import br.com.softplan.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final String DEFAULT_PASSWORD = "password";

	public List<UsuarioDTO> findAll() {
		return usuarioRepository.findAll().stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
	}

	public UsuarioDTO findById(Long id) {
		return usuarioRepository.findById(id).map(u -> new UsuarioDTO(u))
				.orElseThrow(() -> new EntityNotFoundException());
	}

	public UsuarioDTO save(UsuarioDTO usuarioDto) {

		Usuario Usuario = new Usuario(usuarioDto);
		Usuario.setCargo(Cargos.getValueFromDs(usuarioDto.getCargo()));
		Usuario.setSenha(passwordEncoder.encode(DEFAULT_PASSWORD));

		if (Usuario.getId() == null && usuarioRepository.findByEmail(Usuario.getEmail()) != null) {
			throw new EmailExistenteException(Usuario.getEmail());
		}

		Usuario savedUsuario = usuarioRepository.save(Usuario);

		return new UsuarioDTO(savedUsuario);
	}

	public Usuario getUsuarioLogado() {
		return usuarioRepository
				.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toLowerCase())
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Transactional
	public void delete(Long id) {
		usuarioRepository.findById(id).map(u -> {
			//UsuarioProcessService.deleteFromUsuarioId(u.getId());
			usuarioRepository.delete(u);
			return u;
		}).orElseThrow(() -> new EntityNotFoundException());
	}

}
