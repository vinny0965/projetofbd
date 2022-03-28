package br.com.barbeariaFurao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AplicationExceptionHandeler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EnderecoResouceException.class)
	public ResponseEntity exceptionResouceEndereco(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Erro");
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdministradorResourceException.class)
	public ResponseEntity exceptionResourceAdministrador(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), "algum campo digitado é invalido");
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	

	
	@ExceptionHandler(EnderecoNotFoundException.class)
	public ResponseEntity enderecoNotFound(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), "endereco nao encontrado pelo id");
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdministradorNotFoundException.class)
	public ResponseEntity exceptionNotFoundAdministrador(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), "administrador não encontrado pelo id");
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
	
}
