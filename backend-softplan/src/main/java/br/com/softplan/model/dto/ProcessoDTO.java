package br.com.softplan.model.dto;

import java.util.List;

import org.junit.platform.commons.util.StringUtils;

import br.com.softplan.model.entity.Processo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoDTO {
	
	private Long id;
	
	private String titulo;
	
	private String dsParecer;
	
	private Boolean pendente;
	
	private List<UsuarioDTO> usuariosProcesso;
	
	public ProcessoDTO(Processo processo) {
		this.id = processo.getId();
		this.titulo = processo.getTitulo();
		this.dsParecer = processo.getDsParecer();
	}
	
	
	
	public boolean isPendente() {
		return StringUtils.isBlank(this.dsParecer) ? true : false;
	}
	
	
	

}
