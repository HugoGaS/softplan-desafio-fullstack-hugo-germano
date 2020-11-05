package br.com.softplan.model.dto;

import br.com.softplan.model.entity.Parecer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParecerDTO {

	private Long id;

	private String dsParecer;

	private ProcessoDTO processo;

	private UsuarioDTO usuario;

	public ParecerDTO(Parecer parecer) {
		this.id = parecer.getId();
		this.dsParecer = parecer.getDsParecer();
	}

}
