package br.com.mercadolivre.linktracker.handler;

import br.com.mercadolivre.linktracker.exception.LinkDoesNotExistingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LinkExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LinkDoesNotExistingException.class)
    public ResponseEntity<Object> linkDoesNotExistingException(){
        return new ResponseEntity<>("Invalide LinkId", HttpStatus.NOT_FOUND);
    }
}
