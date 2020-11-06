package br.com.softplan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.model.dto.ProcessoDTO;
import br.com.softplan.services.ProcessoService;

@RestController
@RequestMapping("/processo")
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	@GetMapping
	public ResponseEntity<List<ProcessoDTO>> findAll() {
		return ResponseEntity.ok(processoService.findAll());
	}

	@GetMapping("/{processoId}")
	public ResponseEntity<ProcessoDTO> findById(@PathVariable Long processoId) {
		return ResponseEntity.ok(processoService.findById(processoId));
	}

	// @PostMapping
	// public ResponseEntity<ProcessoDTO> save(@RequestBody @Valid ProcessoDTO
	// processoDTO,
	// UriComponentsBuilder uriBuilder) {
	// ProcessoDTO newProcesso = processoService.save(processoDTO);
	//
	// URI uri =
	// uriBuilder.path("/processo/{id}").buildAndExpand(processoDTO.getId()).toUri();
	//
	// return ResponseEntity.created(uri).body(newProcesso);
	// }

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		// Processo processo = processoService.findById(id);
		// if (processo != null && processo.getId() != null) {
		// processoService.delete(id);
		// return ResponseEntity.noContent().build();
		// }
		return ResponseEntity.notFound().build();
	}

}
