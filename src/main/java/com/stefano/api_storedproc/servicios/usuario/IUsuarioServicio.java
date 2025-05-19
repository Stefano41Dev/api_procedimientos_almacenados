package com.stefano.api_storedproc.servicios.usuario;

import com.stefano.api_storedproc.entidades.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    List<Usuario> obtenerUsuarios();
    Usuario obtenerUsuario(Integer id);
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Integer id);
}
