package org.example.gtgapi.restcontroller;


import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/usuario")
public class UsuarioRESTController {

    @Autowired
    UsuarioDAOImpl UsuarioService;

    @GetMapping("/me")
    public Usuario miUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return UsuarioService.findByUsername(username);
    }
}
