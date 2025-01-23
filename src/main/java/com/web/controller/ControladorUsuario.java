package com.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}