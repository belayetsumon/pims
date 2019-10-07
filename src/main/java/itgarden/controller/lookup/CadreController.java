/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.Cadre;
import itgarden.repository.CadreRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/cadre")
@PreAuthorize("hasAuthority('cadre')")
public class CadreController {

    @Autowired
    CadreRepository cadreRepository;

    @RequestMapping("/index")
    public String index(Model model, Cadre cadre) {
        model.addAttribute("list", cadreRepository.findAll());
        return "pims/lookup/cadre";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Cadre cadre) {
        model.addAttribute("cadre", cadreRepository.findById(id));
        model.addAttribute("list", cadreRepository.findAll());
        return "pims/lookup/cadre";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Cadre cadre, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", cadreRepository.findAll());
            return "pims/lookup/cadre";
        }
        cadreRepository.save(cadre);
        return "redirect:/cadre/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Cadre cadre) {
        cadreRepository.deleteById(id);
        return "redirect:/cadre/index";
    }

}
