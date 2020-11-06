package br.com.softplan.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioProcesso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Processo processo;

	@ManyToOne
	private Usuario usuario;
	
	public UsuarioProcesso(Processo processo, Usuario usuario) {
		this.processo = processo;
		this.usuario = usuario;
	}
	
	

}
