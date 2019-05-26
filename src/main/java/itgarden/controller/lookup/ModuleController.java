/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.Module;
import itgarden.repository.ModuleRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;

    @RequestMapping("/index")
    public String index(Model model,Module module) {
        model.addAttribute("list", moduleRepository.findAll());
        return "pims/lookup/module";

    }
    
    
@RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Module module) {
        model.addAttribute("module", moduleRepository.findById(id));
        model.addAttribute("list", moduleRepository.findAll());
        return "pims/lookup/module";
    }

    
    @RequestMapping("/save")
    public String save(Model model, @Valid Module module, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", moduleRepository.findAll());
            return "pims/lookup/module";
        }
        moduleRepository.save(module);
        return "redirect:/module/index";
    }
    
    

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Module module) {
        moduleRepository.deleteById(id);
        return "redirect:/module/index";
    }
    
    
}
