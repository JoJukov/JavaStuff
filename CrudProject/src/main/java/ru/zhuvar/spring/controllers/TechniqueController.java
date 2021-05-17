package ru.zhuvar.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zhuvar.spring.dao.TechniqueDAO;
import ru.zhuvar.spring.models.Technique;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/tech")
public class TechniqueController {

    private final TechniqueDAO techniqueDAO;

    @Autowired
    public TechniqueController(TechniqueDAO techniqueDAO) {
        this.techniqueDAO = techniqueDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("technic", techniqueDAO.index());
        return "technique/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("technic", techniqueDAO.show(id));
        return "technique/show";
    }

    @GetMapping("/new")
    public String newTech(Model model) {
        model.addAttribute("technic", new Technique());
        return "technique/new";
    }

    @PostMapping()
    public String createTech(@ModelAttribute("technic") @Valid Technique technique
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(1);
            return "technique/new";
        }
        techniqueDAO.save(technique);
        return "redirect:/tech";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("technic" ,techniqueDAO.show(id));
        return "technique/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("technic") @Valid Technique technique
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "technique/edit";
        }
        techniqueDAO.update(id, technique);
        return "redirect:/tech";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        techniqueDAO.delete(id);
        return "redirect:/tech";
    }

}
