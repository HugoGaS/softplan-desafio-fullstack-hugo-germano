package br.com.softplan.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioProcessoDTO {

	private Long id;

	private ProcessoDTO processo;

	private UsuarioDTO usuario;

}
