package com.web.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class ExceptionMensagemErro 
{
  private String caminho;
  private String metodo;
  private int status;
  private String statusTexto;
  private String mensagem;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Map<String, String> erros;

  public ExceptionMensagemErro () {}

  public ExceptionMensagemErro(HttpServletRequest request, HttpStatus status, String mensagem)
  {
    this.caminho = request.getRequestURI();
    this.metodo = request.getMethod();
    this.status = status.value();
    this.statusTexto = status.getReasonPhrase();
    this.mensagem = mensagem;
  }

  public ExceptionMensagemErro(HttpServletRequest request, HttpStatus status, String mensagem, BindingResult resultado)
  {
    this.caminho = request.getRequestURI();
    this.metodo = request.getMethod();
    this.status = status.value();
    this.statusTexto = status.getReasonPhrase();
    this.mensagem = mensagem;
    adicionarErros(resultado);
  }
    
  private void adicionarErros(BindingResult resultado) 
  {
    this.erros = new HashMap<>();
    for(FieldError fieldError : resultado.getFieldErrors())
    {
      this.erros.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
  }
}