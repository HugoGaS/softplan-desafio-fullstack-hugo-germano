package br.com.softplan.exception;

import org.springframework.http.HttpStatus;

public class LoginFailedException extends ApiException {
	
	private static final long serialVersionUID = 209908519421603721L;

	public LoginFailedException() {
		super(HttpStatus.UNAUTHORIZED);
	}

	@Override
	public MessageErrorBuilder getExceptionDTO() {
		return MessageErrorBuilder.builder()
				.mensagem("Login inválido! Favor verificar os dados informados!")
				.build();
	}


}
