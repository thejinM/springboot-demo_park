package com.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Usuario;
import com.service.ServicoUsuario;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class ControladorUsuario 
{
  private final ServicoUsuario servicoUsuario;

  @PostMapping
  public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario)
  {
    Usuario u = servicoUsuario.salvar(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(u);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getByID(@PathVariable Long id)
  {
    Usuario u = servicoUsuario.buscarPorID(id);
    return ResponseEntity.ok(u);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Usuario> atualizarSenha(@PathVariable Long id, @RequestBody Usuario usuario)
  {
    Usuario u = servicoUsuario.atualizarSenha(id, usuario.getSenha());
    return ResponseEntity.ok(u);
  }

  @GetMapping
  public ResponseEntity<List<Usuario>> buscarTodos()
  {
    List<Usuario> us = servicoUsuario.buscarTodos();
    return ResponseEntity.ok(us);
  }
}