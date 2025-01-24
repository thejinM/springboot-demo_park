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
import com.web.DTO.UsuarioCreateDTO;
import com.web.DTO.UsuarioResponseDTO;
import com.web.DTO.UsuarioSenhaDTO;
import com.web.DTO.mapper.UsuarioMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class ControladorUsuario 
{
  private final ServicoUsuario servicoUsuario;

  @PostMapping
  public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioCreateDTO usuarioDTO)
  {
    Usuario u = servicoUsuario.salvar(UsuarioMapper.toUsuario(usuarioDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDTO(u));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioResponseDTO> getByID(@PathVariable Long id)
  {
    Usuario u = servicoUsuario.buscarPorID(id);
    return ResponseEntity.ok(UsuarioMapper.toDTO(u));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> atualizarSenha(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDTO usuario)
  {
    servicoUsuario.atualizarSenha(id, usuario.getSenhaAtual(), usuario.getNovaSenha(), usuario.getConfirmaSenha());
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<UsuarioResponseDTO>> buscarTodos()
  {
    List<Usuario> us = servicoUsuario.buscarTodos();
    return ResponseEntity.ok(UsuarioMapper.toListDTO(us));
  }
}