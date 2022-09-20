package com.demo.novatecdemo.exeption;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;



@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public void handleException(DataIntegrityViolationException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocurrio un error interno Profavor intente mas tarde");
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public void handleException(HttpClientErrorException e, HttpServletResponse response) throws IOException {
		response.sendError(e.getStatusCode().value(), e.getStatusText());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public void handleException(ResourceNotFoundException e, HttpServletResponse response) throws IOException {        
		response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}
}
