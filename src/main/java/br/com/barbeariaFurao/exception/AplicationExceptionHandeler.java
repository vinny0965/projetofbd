package br.com.barbeariaFurao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.barbeariaFurao.dto.DefaultError;


@ControllerAdvice
public class AplicationExceptionHandeler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EnderecoResouceException.class)
	public ResponseEntity handlerException(Exception e) {
		DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Erro");
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	
	

}
