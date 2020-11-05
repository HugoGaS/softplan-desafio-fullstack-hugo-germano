package br.com.softplan.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.softplan.model.dto.UsuarioDTO;
import br.com.softplan.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@GetMapping("/{usuarioId}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long usuarioId) {
		return ResponseEntity.ok(usuarioService.findById(usuarioId));
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioDTO usuarioDTO, UriComponentsBuilder uriBuilder) {
		UsuarioDTO newUsuario = usuarioService.save(usuarioDTO);

		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioDTO.getId()).toUri();

		return ResponseEntity.created(uri).body(newUsuario);
	}

	@PutMapping("/{usuarioId}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Long usuarioId, @RequestBody @Valid UsuarioDTO usuarioDTO) {

		UsuarioDTO usuario = usuarioService.findById(usuarioId);
		if (usuario != null && usuario.getId() != null) {
			usuarioDTO.setId(usuarioId);
			return ResponseEntity.ok(usuarioService.save(usuarioDTO));
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		UsuarioDTO usuario = usuarioService.findById(id);
		if (usuario != null && usuario.getId() != null) {
			usuarioService.delete(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}

}
