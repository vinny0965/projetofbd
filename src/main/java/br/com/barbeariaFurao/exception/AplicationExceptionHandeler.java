package br.com.barbeariaFurao.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.barbeariaFurao.dto.DefaultError;


@ControllerAdvice
public class AplicationExceptionHandeler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EnderecoResouceException.class)
	public ResponseEntity exceptionResouceEndereco(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Erro");
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdministradorResourceException.class)
	public ResponseEntity exceptionResourceAdministrador(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Erro ao");
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity exceptionId(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), "id inserido invalido");
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
	

}
