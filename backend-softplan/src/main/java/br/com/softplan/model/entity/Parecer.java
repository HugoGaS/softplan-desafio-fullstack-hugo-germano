package br.com.softplan.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Parecer {
	
	@Id @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String dsParecer;
	
	@ManyToOne
	private Processo processo;
	
	@Column
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@ManyToOne
	private Usuario autor;
	


}
