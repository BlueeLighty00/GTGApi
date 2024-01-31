package org.example.gtgapi.restcontroller;

import org.example.gtgapi.models.dao.IngredienteDAOImpl;
import org.example.gtgapi.models.entity.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteRESTController {

    @Autowired
    IngredienteDAOImpl IngredienteService;

    @GetMapping("/list")
    public Ingrediente[] ingredientes() {

        return IngredienteService.findAll();
    }

    @GetMapping("/list/{id}")
    public Ingrediente ingredienteID(@PathVariable Long id) {

        return IngredienteService.findById(id);
    }

}