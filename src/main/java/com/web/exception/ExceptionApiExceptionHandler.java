package com.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Exception.ExceptionUsuarioNaoEncontrado;
import com.Exception.ExceptionViolacaoEmailUnico;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionApiExceptionHandler 
{
    @ExceptionHandler(ExceptionUsuarioNaoEncontrado.class)
    public ResponseEntity<ExceptionMensagemErro> exceptionUsuarioNaoEncontrado(ExceptionUsuarioNaoEncontrado exception, HttpServletRequest request)
    {
      log.error("Erro na API - ", exception);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(new ExceptionMensagemErro(request, HttpStatus.NOT_FOUND, exception.getMessage())); 
    }

  @ExceptionHandler(ExceptionViolacaoEmailUnico.class)
  public ResponseEntity<ExceptionMensagemErro> exceptionViolacaoEmailUnico(ExceptionViolacaoEmailUnico exception, HttpServletRequest request)
  {
    log.error("Erro na API - ", exception);
    return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(new ExceptionMensagemErro(request, HttpStatus.CONFLICT, exception.getMessage())); 
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionMensagemErro> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request, BindingResult resultado)
  {
    log.error("Erro na API - ", exception);
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).contentType(MediaType.APPLICATION_JSON).body(new ExceptionMensagemErro(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campo(s) inválido(s)!", resultado)); 
  }
}