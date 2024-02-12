package org.example.gtgapi.restcontroller;


import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.gtgapi.models.Jwt;
import org.example.gtgapi.models.LoginUsuario;
import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Usuario;
import org.example.gtgapi.security.JWTAuthtenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    UsuarioDAOImpl usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;


    @PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid LoginUsuario usuario) {

        Jwt jwt = new Jwt();

        Usuario usuarioDB = usuarioDao.findByUsername(usuario.getUsername());

        if(usuarioDB == null) {

            return ResponseEntity.badRequest().body("User not found");
        }

        if(!passwordEncoder.matches(usuario.getContrasenya(), usuarioDB.getContrasenya())){

            return ResponseEntity.badRequest().body("Password failed");

        }

        String token = jwtAuthtenticationConfig.getJWTToken(usuarioDB);


        jwt.setToken(token);

        return ResponseEntity.ok(jwt);
	}

}