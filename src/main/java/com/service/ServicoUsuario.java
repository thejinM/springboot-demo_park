package com.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Usuario;
import com.repository.RepositorioUsuario;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicoUsuario 
{
  private final RepositorioUsuario repositorioUsuario;

  @Transactional
  public Usuario salvar(Usuario usuario)
  {
    return repositorioUsuario.save(usuario);
  }
}