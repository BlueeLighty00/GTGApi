package org.example.gtgapi.controller;

import org.example.gtgapi.models.dao.UsuarioDAOImpl;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioDAOImpl usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioDao.findAll());
        return "usuarios";
    }

    @GetMapping("/usuario/{id}")
    public String getUsuarioDetails(Model model, @PathVariable Long id) {
        Usuario usuario = usuarioDao.findById(id);
        model.addAttribute("usuario", usuario);
        return "details_usuario";
    }

    @GetMapping("/usuario/edit/{id}")
    public String getUsuarioEdit(Model model, @PathVariable Long id) {
        Usuario usuario = usuarioDao.findById(id);
        model.addAttribute("usuario", usuario);
        return "edit_usuario";
    }

    @GetMapping("/usuario/create")
    public String createUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "create_usuario";
    }

    @PostMapping("/usuario/create")
    public String newUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuario.setContrasenya(passwordEncoder.encode(usuario.getContrasenya()));
        usuarioDao.save(usuario);
        return "redirect:/usuarios";
    }

    @PostMapping("/usuario/update/{id}")
    public String updateUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioDao.update(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping("/usuario/delete/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioDao.delete(id);
        return "redirect:/usuarios";
    }
}
