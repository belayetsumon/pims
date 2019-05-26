/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.PresentPostingLocation;
import itgarden.repository.PresentPostingLocationRepository;
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
 @RequestMapping("/presentpostinglocation")
public class PresentPostingLocationController {
    
    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;
    
    @RequestMapping("/index")
    public String index(Model model, PresentPostingLocation  presentPostingLocation) {
        model.addAttribute("list", presentPostingLocationRepository.findAll());
        return "pims/lookup/presentpostinglocation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, PresentPostingLocation  presentPostingLocation) {
        model.addAttribute("presentPostingLocation", presentPostingLocationRepository.findById(id));
        model.addAttribute("list", presentPostingLocationRepository.findAll());
        return "pims/lookup/presentpostinglocation";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid PresentPostingLocation  presentPostingLocation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", presentPostingLocationRepository.findAll());
            return "pims/lookup/presentpostinglocation";
        }
        presentPostingLocationRepository.save(presentPostingLocation);
        return "redirect:/presentpostinglocation/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, PresentPostingLocation  presentPostingLocation) {
        presentPostingLocationRepository.deleteById(id);
        return "redirect:/presentpostinglocation/index";
    }

}
