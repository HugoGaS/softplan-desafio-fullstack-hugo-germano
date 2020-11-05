package br.com.softplan.model.dto;

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
	
	private Boolean pendente;
	

}