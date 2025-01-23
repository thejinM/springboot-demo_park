package com.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nomeUsuario", nullable = false, unique = true, length = 100)
  private String nomeUsuario;
  @Column(name = "senha", nullable = false, length = 200)
  private String senha;
  @Column(name = "criadoPor")
  private String criadoPor;
  @Column(name = "modificadoPor")
  private String modificadoPor;
  @Enumerated(EnumType.STRING)
  @Column(name = "perfil", nullable = false, length = 25)
  private Perfil perfil;

  @Column(name = "dataCriacao")
  private LocalDateTime dataCriacao;
  @Column(name = "dataModificacao")
  private LocalDateTime dataModificacao;

  public enum Perfil
  {
    PERFIL_ADMIN,
    PERFIL_CLIENTE;
  }

  @Override
  public int hashCode() 
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) 
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() 
  {
    return "Usuario [id=" + id + "]";
  }
}