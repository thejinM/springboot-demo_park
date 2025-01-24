package com.service;

import java.util.List;

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
  public Usuario atualizarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) 
  {
    if (!novaSenha.equals(confirmaSenha))
    {
      throw new RuntimeException("Senhas não correspondentes! Tente novamente.");
    }

    Usuario u = buscarPorID(id);
    if (!u.getSenha().equals(senhaAtual)) 
    {
      throw new RuntimeException("Senhas não correspondentes! Tente novamente.");
    }

    u.setSenha(novaSenha);
    return u;
  }

  @Transactional(readOnly = true)
  public List<Usuario> buscarTodos() 
  {
    return repositorioUsuario.findAll();
  }
}