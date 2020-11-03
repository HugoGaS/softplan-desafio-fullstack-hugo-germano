package br.com.softplan.exception;

import org.springframework.http.HttpStatus;

public class EmailExistenteException extends ApiException {

	private static final long serialVersionUID = 8636341798822189420L;

	private final String email;

	public EmailExistenteException(String email) {
		super(HttpStatus.BAD_REQUEST);
		this.email = email;
	}

	@Override
	public MessageErrorBuilder getExceptionDTO() {
		return MessageErrorBuilder.builder().mensagem("O email " + email + " já cadastrado no sistema!").build();
	}

}
