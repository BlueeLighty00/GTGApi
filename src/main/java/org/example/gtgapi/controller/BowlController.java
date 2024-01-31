package org.example.gtgapi.controller;

import org.example.gtgapi.models.dao.BowlDAOImpl;
import org.example.gtgapi.models.entity.Bowl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BowlController {

    @Autowired
    BowlDAOImpl bowlDao;

    @GetMapping("/bowls")
    public String bowls(Model model) {
        model.addAttribute("bowls", bowlDao.findAll());
        return "bowls";
    }

    @GetMapping("/bowl/{id}")
    public String getBowlDetails(Model model, @PathVariable Long id) {
        Bowl bowl = bowlDao.findById(id);
        model.addAttribute("bowl", bowl);
        return "details_bowl";
    }

    @GetMapping("/bowl/edit/{id}")
    public String getBowlEdit(Model model, @PathVariable Long id) {
        Bowl bowl = bowlDao.findById(id);
        model.addAttribute("bowl", bowl);
        return "edit_bowl";
    }

    @GetMapping("/bowl/create")
    public String createBowl(Model model) {
        model.addAttribute("bowl", new Bowl());
        return "create_bowl";
    }

    @PostMapping("/bowl/create")
    public String newBowl(@ModelAttribute("bowl") Bowl bowl) {
        bowlDao.save(bowl);
        return "redirect:/bowls";
    }

    @PostMapping("/bowl/update/{id}")
    public String updateBowl(@ModelAttribute("bowl") Bowl bowl) {
        bowlDao.update(bowl);
        return "redirect:/bowls";
    }

    @DeleteMapping("/bowl/delete/{id}")
    public String deleteBowl(@PathVariable Long id) {
        bowlDao.delete(id);
        return "redirect:/bowls";
    }
}