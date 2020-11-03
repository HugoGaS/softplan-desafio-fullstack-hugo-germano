package br.com.softplan.model.dto;

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
	
	private ProcessosDTO processo;
	
	private UsuarioDTO usuario;
	

}
