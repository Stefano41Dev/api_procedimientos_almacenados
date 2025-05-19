package com.stefano.api_storedproc.servicios.usuario;

import com.stefano.api_storedproc.entidades.Usuario;
import com.stefano.api_storedproc.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServicio implements IUsuarioServicio{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario obtenerUsuario(Integer id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        usuarioRepositorio.deleteById(id);
    }
}
