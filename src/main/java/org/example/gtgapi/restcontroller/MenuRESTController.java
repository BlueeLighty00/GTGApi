package org.example.gtgapi.restcontroller;

import org.example.gtgapi.models.dao.MenuDAOImpl;
import org.example.gtgapi.models.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuRESTController {

    @Autowired
    MenuDAOImpl MenuService;

    @GetMapping("/list")
    public Menu[] menus() {

        return MenuService.findAll();
    }

    @GetMapping("/list/{id}")
    public Menu menuID(@PathVariable Long id) {

        return MenuService.findById(id);
    }
}
