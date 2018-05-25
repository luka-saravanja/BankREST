package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception ex,WebRequest request)
	{
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),"Something went wrong");
		return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(),HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrorMessage> somethingWentWrong1(Exception ex,WebRequest request)
	{
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),"Something went wrong");
		return new ResponseEntity<ErrorMessage>(errorMessage,new HttpHeaders(),HttpStatus.FORBIDDEN);
	}
	
	

}
