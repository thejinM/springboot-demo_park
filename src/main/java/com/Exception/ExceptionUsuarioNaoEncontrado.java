package com.Exception;

public class ExceptionUsuarioNaoEncontrado extends RuntimeException
{
  public ExceptionUsuarioNaoEncontrado(String mensagem)
  {
    super(mensagem);
  }
}