package org.example.gtgapi.restcontroller;


import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/usuario")
public class UsuarioRESTController {

    @Autowired
    UsuarioDAOImpl UsuarioService;

    @GetMapping("/list")
    public Usuario[] usuarios() {

        return UsuarioService.findAll();
    }

    @GetMapping("/list/{id}")
    public Usuario pedidoID(@PathVariable Long id) {

        return UsuarioService.findById(id);
    }

}
