package org.example.gtgapi.restcontroller;


import jakarta.validation.Valid;
import org.example.gtgapi.models.RegistroUsuario;
import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioDAOImpl usuarioDao;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid RegistroUsuario nuevousuario) {
        nuevousuario.setContrasenya(passwordEncoder.encode(nuevousuario.getContrasenya()));
        Usuario usuario = new Usuario();
        usuario.setNombre(nuevousuario.getNombre());
        usuario.setApellidos(nuevousuario.getApellidos());
        usuario.setCorreo(nuevousuario.getCorreo());
        usuario.setTelefono(nuevousuario.getTelefono());
        usuario.setDireccion(nuevousuario.getDireccion());
        usuario.setUsername(nuevousuario.getUsername());
        usuario.setContrasenya(passwordEncoder.encode(nuevousuario.getContrasenya()));
        usuarioDao.save(usuario);

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

}