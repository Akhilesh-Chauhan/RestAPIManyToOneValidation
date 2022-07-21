package com.akhilesh.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.akhilesh.exception.CidNotFoundException;
import com.akhilesh.exception.ErrorInfo;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	Environment environment;
	
	/*@ExceptionHandler(CidNotFoundException.class)
	public ResponseEntity<ErrorInfo> CidNotFoundExceptionHandler(CidNotFoundException exception)throws CidNotFoundException
	{
		System.out.println("CUSTOMIZED EXCEPTION");
		ErrorInfo error=new ErrorInfo();
		//error.setErrorMessage("CID NOT FOUND");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception)
	{
		System.out.println("NORMAL EXCEPTION");
		ErrorInfo error=new ErrorInfo();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMessage(environment.getProperty("General.EXCPTION_MESSAGE"));
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		    errorInfo.setTimestamp(LocalDateTime.now());
			
			String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(", "));
			errorInfo.setErrorMessage(errorMsg);
			System.out.println(exception.getBindingResult());
		
			return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}

