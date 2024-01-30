package org.example.gtgapi.controller;

import org.example.gtgapi.models.dao.RolDAOImpl;
import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Rol;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    private UsuarioDAOImpl usuarioService;

    @Autowired
    private RolDAOImpl rolService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.findAll());
        return "registerForm";
    }

    @PostMapping(value = "/register", consumes = "application/x-www-form-urlencoded\n")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> registerSubmit(@ModelAttribute Usuario usuario, @RequestParam("roles") String rolesIds) {
        Set<Rol> roles = new HashSet<>();

        for (String roleId : rolesIds.split(",")) {
            Rol rol = rolService.findById(Long.parseLong(roleId));
            if (rol != null) {
                roles.add(rol);
            }
        }

        if (roles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No roles provided.");
        }

        usuario.setRolesAsociados(roles);

        try {
            usuarioService.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registration successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during user registration");
        }
    }
}
