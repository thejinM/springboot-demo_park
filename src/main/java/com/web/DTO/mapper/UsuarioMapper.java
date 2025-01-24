package com.web.DTO.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.entities.Usuario;
import com.web.DTO.UsuarioCreateDTO;
import com.web.DTO.UsuarioResponseDTO;

public class UsuarioMapper 
{
  public static Usuario toUsuario(UsuarioCreateDTO usuarioDTO)
  {
    return new ModelMapper().map(usuarioDTO, Usuario.class);
  }  

  public static UsuarioResponseDTO toDTO(Usuario usuario)
  {
    String perfil = usuario.getPerfil().name().substring("PERFIL_".length());
    PropertyMap<Usuario, UsuarioResponseDTO> props = new PropertyMap<Usuario,UsuarioResponseDTO>() 
    {
      @Override
      protected void configure()
      {
        map().setPerfil(perfil);
      }  
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(usuario, UsuarioResponseDTO.class);
  }  
}