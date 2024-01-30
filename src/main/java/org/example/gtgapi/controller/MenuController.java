package org.example.gtgapi.controller;

import org.example.gtgapi.models.dao.MenuDAOImpl;
import org.example.gtgapi.models.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuController {

    @Autowired
    private MenuDAOImpl menuService;

    @GetMapping("/menus")
    public String menus(Model model) {
        model.addAttribute("menus", menuService.findAll());
        return "menus";
    }

    @GetMapping("/menus/{id}")
    public String getMenuDetails(Model model, @PathVariable Long id) {
        Menu menu = menuService.findById(id);
        model.addAttribute("menu", menu);
        return "details_menu";
    }

    @GetMapping("/menus/edit/{id}")
    public String getMenuEdit(Model model, @PathVariable Long id) {
        Menu menu = menuService.findById(id);
        model.addAttribute("menu", menu);
        return "edit_menu";
    }

    @GetMapping("/menus/create")
    public String createMenu(Model model) {
        model.addAttribute("menu", new Menu());
        return "create_menu";
    }

    @PostMapping("/menus/create")
    public String newMenu(@ModelAttribute("menu") Menu menu) {
        menuService.save(menu);
        return "redirect:/menus";
    }

    @PostMapping("/menus/update/{id}")
    public String updateMenu(@ModelAttribute("menu") Menu menu, @PathVariable Long id) {
        menuService.update(menu);
        return "redirect:/menus";
    }

    @DeleteMapping("/menus/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
        return "redirect:/menus";
    }
}
