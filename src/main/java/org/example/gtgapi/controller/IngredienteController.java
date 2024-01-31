package org.example.gtgapi.controller;

import org.example.gtgapi.models.dao.IngredienteDAOImpl;
import org.example.gtgapi.models.entity.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredienteController {
    @Autowired
    IngredienteDAOImpl ingredienteDao;

    @GetMapping("/ingredientes")
    public String ingredientes(Model model) {
        model.addAttribute("ingredientes", ingredienteDao.findAll());
        return "ingredientes";
    }

    @GetMapping("/ingrediente/{id}")
    public String getIngredienteDetails(Model model, @PathVariable Long id) {
        Ingrediente ingrediente = ingredienteDao.findById(id);
        model.addAttribute("ingrediente", ingrediente);
        return "details_ingrediente";
    }

    @GetMapping("/ingrediente/edit/{id}")
    public String getIngredienteEdit(Model model, @PathVariable Long id) {
        Ingrediente ingrediente  = ingredienteDao.findById(id);
        model.addAttribute("ingrediente", ingrediente);
        return "edit_ingrediente";
    }

    @GetMapping("/ingrediente/create")
    public String createIngrediente(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        return "create_ingrediente";
    }

    @PostMapping("/ingrediente/create")
    public String newIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente) {

        ingredienteDao.save(ingrediente);
        return "redirect:/ingredientes";
    }


    @PostMapping("/ingrediente/update/{id}")
    public String updateIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente) {

        ingredienteDao.update(ingrediente);
        return "redirect:/ingredientes";
    }

    @DeleteMapping("/ingrediente/delete/{id}")
    public String deleteIngrediente(@PathVariable Long id) {

        ingredienteDao.delete(id);
        return "redirect:/ingredientes";
    }
}
