package org.si.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.si.exception.InvalidFeildException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {
    
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = InvalidFeildException.class)
	public ResponseEntity<Object> handleInvalidFieldException(InvalidFeildException invalidFeildException
			,WebRequest request) {
		Map<String, Object> body= new LinkedHashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message",invalidFeildException.getMessage());
		return  new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST); 
	}
	   @ExceptionHandler(RuntimeException.class)
	    public final ResponseEntity<Object> handleAllExceptions(RuntimeException ex) {
			Map<String, Object> body= new LinkedHashMap<String, Object>();
		   body.put("timestamp", LocalDateTime.now());
	        body.put("message",new RuntimeException("the client is null").getMessage());
			return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	        // Log and return
	    }

}
