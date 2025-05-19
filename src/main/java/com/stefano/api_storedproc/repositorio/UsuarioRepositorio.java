package com.stefano.api_storedproc.repositorio;

import com.stefano.api_storedproc.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
