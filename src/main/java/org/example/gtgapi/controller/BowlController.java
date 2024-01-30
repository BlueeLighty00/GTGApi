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
    private BowlDAOImpl bowlService;

    @GetMapping("/bowls")
    public String bowls(Model model) {
        model.addAttribute("bowls", bowlService.findAll());
        return "bowls";
    }

    @GetMapping("/bowls/{id}")
    public String bowl(Model model, @PathVariable(value = "id") final long id) {
        model.addAttribute("bowl", bowlService.findById(id));
        return "view_bowl";
    }

    @GetMapping("/bowls/create")
    public String createBowl(Model model) {
        model.addAttribute("bowl", new Bowl());
        return "create_bowl";
    }

    @PostMapping("/bowls/create")
    public String newBowl(@ModelAttribute Bowl bowl) {
        bowlService.save(bowl);
        return "redirect:/bowls/" + bowl.getId();
    }

    @GetMapping("/bowls/update/{id}")
    public String updateBowl(Model model, @PathVariable(value = "id") final long id) {
        Bowl bowl = bowlService.findById(id);
        model.addAttribute("bowl", bowl);
        return "update_bowl";
    }

    @PostMapping("/bowls/update/{id}")
    public String updateBowlPost(@ModelAttribute Bowl bowl, @PathVariable(value = "id") final long id) {
        bowlService.update(bowl);
        return "redirect:/bowls/" + id;
    }

    @DeleteMapping("/bowls/delete/{id}")
    public String deleteBowl(@PathVariable(value = "id") final long id) {
        bowlService.delete(id);
        return "redirect:/bowls";
    }
}
