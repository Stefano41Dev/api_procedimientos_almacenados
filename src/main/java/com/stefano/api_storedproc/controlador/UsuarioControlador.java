package com.stefano.api_storedproc.controlador;

import com.stefano.api_storedproc.entidades.Usuario;
import com.stefano.api_storedproc.servicios.usuario.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-rest")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios() {
        return usuarioServicio.obtenerUsuarios();
    }
    @GetMapping("/usuarios/{id}")
    public Usuario obtenerUsuario(@PathVariable int id) {
        return usuarioServicio.obtenerUsuario(id);
    }
    @PostMapping("/usuarios")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        usuarioServicio.guardarUsuario(usuario);
        return ResponseEntity.ok("Se creo el usuario correctamente");
    }
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> modificarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
        Usuario usuarioActual = usuarioServicio.obtenerUsuario(id);
        if (usuarioActual != null) {
            usuarioActual.setNombreUsuario(usuario.getNombreUsuario());
            usuarioActual.setCorreo(usuario.getCorreo());
            usuarioServicio.guardarUsuario(usuarioActual);
        }
        return ResponseEntity.ok("Se modifico el usuario correctamente");
    }
    @DeleteMapping("/usarios/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        usuarioServicio.eliminarUsuario(id);
        return ResponseEntity.ok("Se elimino el usuario correctamente");
    }

}
