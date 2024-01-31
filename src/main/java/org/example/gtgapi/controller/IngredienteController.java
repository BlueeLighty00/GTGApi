package org.example.gtgapi.controller;

import org.example.gtgapi.models.dao.IngredienteDAOImpl;
import org.example.gtgapi.models.entity.Ingrediente;
import org.example.gtgapi.models.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredienteController {
    @Autowired
    IngredienteDAOImpl IngredienteDao;

    @GetMapping("/ingredientes")
    public String menus(Model model) {
        model.addAttribute("ingredientes", IngredienteDao.findAll());
        return "ingredientes";
    }

    @GetMapping("/ingrediente/{id}")
    public String getMenuDetails(Model model, @PathVariable Long id) {
        Ingrediente ingrediente = IngredienteDao.findById(id);
        model.addAttribute("ingrediente", ingrediente);
        return "details_ingrediente";
    }

    @GetMapping("/ingrediente/edit/{id}")
    public String getMenuEdit(Model model, @PathVariable Long id) {
        Ingrediente ingrediente  = IngredienteDao.findById(id);
        model.addAttribute("ingrediente", ingrediente);
        return "edit_ingrediente";
    }

    @GetMapping("/ingrediente/create")
    public String createMenu(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        return "create_ingrediente";
    }

    @PostMapping("/ingrediente/create")
    public String newMenu(@ModelAttribute("ingrediente") Ingrediente ingrediente) {

        IngredienteDao.save(ingrediente);
        return "redirect:/ingredientes";
    }


    @PostMapping("/ingrediente/update/{id}")
    public String updateMenu(@ModelAttribute("menu") Ingrediente ingrediente) {

        IngredienteDao.update(ingrediente);
        return "redirect:/ingredientes";
    }

    @DeleteMapping("/ingrediente/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {

        IngredienteDao.delete(id);
        return "redirect:/ingredientes";
    }
}
