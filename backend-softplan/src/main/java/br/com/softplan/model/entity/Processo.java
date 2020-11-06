package br.com.softplan.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.softplan.model.dto.ProcessoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Processo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String dsParecer;


	public Processo(ProcessoDTO processoDTO) {
		this.id = processoDTO.getId();
		this.titulo = processoDTO.getTitulo();
		this.dsParecer = processoDTO.getDsParecer();
	}

}
