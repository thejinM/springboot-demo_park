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

  @Transactional(readOnly = true)
  public Usuario buscarPorID(Long id)
  {
    return repositorioUsuario.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
  }

  @Transactional
  public Usuario atualizarSenha(Long id, String senha) 
  {
    Usuario u = buscarPorID(id);
    u.setSenha(senha);
    return u;
  }
}