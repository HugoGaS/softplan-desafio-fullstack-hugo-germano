package br.com.softplan.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public abstract class ApiException extends RuntimeException {

	private static final long serialVersionUID = -273980780951040224L;

	@Getter
	private final HttpStatus httpStatus;

	public abstract MessageErrorBuilder getExceptionDTO();

	protected ApiException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
