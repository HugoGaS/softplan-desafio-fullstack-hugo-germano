package br.com.softplan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.enums.Perfis;
import br.com.softplan.model.dto.ProcessoDTO;
import br.com.softplan.model.dto.UsuarioDTO;
import br.com.softplan.model.entity.Processo;
import br.com.softplan.model.entity.Usuario;
import br.com.softplan.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioProcessoService usuarioProcessoService;

	public List<ProcessoDTO> findAll() {
		List<ProcessoDTO> processos = new ArrayList<>();

		if (Perfis.USUARIO_FINALIZADOR.equals(getUsuarioLogado().getPerfil())) {
			processos.addAll(usuarioProcessoService.findPedenteByUsuarioId(getUsuarioLogado().getId()).stream()
					.map(u -> new ProcessoDTO(u.getProcesso())).collect(Collectors.toList()));
		} else {
			processos.addAll(
					processoRepository.findAll().stream().map(p -> new ProcessoDTO(p)).collect(Collectors.toList()));
		}
		processos.forEach(e -> e.setUsuariosProcesso(getUsuariosProcesso(e.getId())));
		return processos;
	}

	public ProcessoDTO findById(Long id) {
		Processo processo = processoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		ProcessoDTO processoDTO = getProcessoRetorno(processo);
		return processoDTO;
	}

	@Transactional
	public ProcessoDTO save(ProcessoDTO processoDto) {
		
		Processo processo = new Processo(processoDto);
		Processo novoProcesso = processoRepository.save(processo);
		
		atribuirUsuariosProcesso(processoDto, novoProcesso);
		
		ProcessoDTO processoRetorno = getProcessoRetorno(novoProcesso);
	
		return processoRetorno;

	}


	private List<UsuarioDTO> getUsuariosProcesso(Long processoId) {
		return usuarioProcessoService.findByProcessoId(processoId).stream().map(u -> new UsuarioDTO(u.getUsuario()))
				.collect(Collectors.toList());
	}

	
	private ProcessoDTO getProcessoRetorno(Processo processo) {
		ProcessoDTO processoDTO = new ProcessoDTO(processo);
		processoDTO.setUsuariosProcesso(getUsuariosProcesso(processo.getId()));
		return processoDTO;
	}
	
	private void atribuirUsuariosProcesso(ProcessoDTO processoDto, Processo novoProcesso) {
		if(!processoDto.getUsuariosProcesso().isEmpty()) {
			processoDto.getUsuariosProcesso().forEach(u -> {
				usuarioProcessoService.atribuir(novoProcesso, u);
			});
		}
	}
	
	private Usuario getUsuarioLogado() {
		return usuarioService.getUsuarioLogado();
	}

}
