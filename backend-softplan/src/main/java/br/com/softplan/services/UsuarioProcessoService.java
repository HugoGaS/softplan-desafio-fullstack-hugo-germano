package br.com.softplan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softplan.model.entity.UsuarioProcesso;
import br.com.softplan.repository.UsuarioProcessoRepository;

@Service
public class UsuarioProcessoService {

	@Autowired
	private UsuarioProcessoRepository parecerRepository;

	public List<UsuarioProcesso> findAll() {
		return parecerRepository.findAll();
	}
	
	public List<UsuarioProcesso> findByUsuarioId(Long id){
		return parecerRepository.findByUsuarioId(id);
	}
	
	public List<UsuarioProcesso> findByProcessoId(Long id){
		return parecerRepository.findByProcessoId(id);
	}
	
	public List<UsuarioProcesso> findPedenteByUsuarioId(Long id) {
		return parecerRepository.findPedenteByUsuarioId(id);
	}


}
