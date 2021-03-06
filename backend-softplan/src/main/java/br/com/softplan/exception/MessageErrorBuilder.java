package br.com.softplan.exception;

import java.util.Optional;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MessageErrorBuilder {
	
		private final String mensagem;
		
		private final String mensagemDetalhada;
		
		public MessageErrorBuilder(String mensagem, String mensagemDetalhada) {
			this.mensagem = mensagem;
			this.mensagemDetalhada = Optional.ofNullable(mensagemDetalhada)
					.orElse(mensagem);
		}
		

}
