package org.example.gtgapi.restcontroller;

import org.example.gtgapi.models.dao.BowlDAOImpl;
import org.example.gtgapi.models.entity.Bowl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bowl")
public class BowlRESTController {

    @Autowired
    BowlDAOImpl BowlService;

    @GetMapping("/list")
    public Bowl[] bowls() {

        return BowlService.findAll();
    }

    @GetMapping("/list/{id}")
    public Bowl bowlID(@PathVariable Long id) {

        return BowlService.findById(id);
    }
}
