package org.example.gtgapi.restcontroller;


import jakarta.validation.Valid;
import org.example.gtgapi.models.RegistroUsuario;
import org.example.gtgapi.models.dao.RolDAOImpl;
import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Rol;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioDAOImpl usuarioDao;

    @Autowired
    RolDAOImpl RolService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid RegistroUsuario nuevousuario) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nuevousuario.getNombre());
        usuario.setApellidos(nuevousuario.getApellidos());
        usuario.setCorreo(nuevousuario.getCorreo());
        usuario.setTelefono(nuevousuario.getTelefono());
        usuario.setDireccion(nuevousuario.getDireccion());
        usuario.setUsername(nuevousuario.getUsername());
        usuario.setContrasenya(passwordEncoder.encode(nuevousuario.getContrasenya()));

        if(usuarioDao.findByUsername(nuevousuario.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Ya existe una cuenta con ese nombre de usuario");
        }
        if(usuarioDao.findByEmail(nuevousuario.getCorreo()) != null) {
            return ResponseEntity.badRequest().body("Ya existe una cuenta con ese correo electronico");
        }

        Set<Rol> roles = new HashSet<>();

        roles.add(RolService.findById(2));

        usuario.setRolesAsociados(roles);

        usuarioDao.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }

}
