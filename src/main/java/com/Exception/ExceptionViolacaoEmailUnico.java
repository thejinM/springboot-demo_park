package com.Exception;

public class ExceptionViolacaoEmailUnico extends RuntimeException
{
  public ExceptionViolacaoEmailUnico(String mensagem)
  {
    super(mensagem);
  }
}