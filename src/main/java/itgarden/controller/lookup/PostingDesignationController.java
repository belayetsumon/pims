/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.PostingDesignation;
import itgarden.repository.PostingDesignationRepository;
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
@RequestMapping("/postingdesignation")
@PreAuthorize("hasAuthority('module')")
public class PostingDesignationController {
    
@Autowired
   PostingDesignationRepository postingDesignationRepository;
    
    @RequestMapping("/index")
    public String index(Model model, PostingDesignation postingDesignation) {
        model.addAttribute("list", postingDesignationRepository.findAll());
        return "pims/lookup/postingdesignation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id,  PostingDesignation postingDesignation) {
        model.addAttribute("postingDesignation", postingDesignationRepository.findById(id));
        model.addAttribute("list", postingDesignationRepository.findAll());
        return "pims/lookup/postingdesignation";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid  PostingDesignation postingDesignation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", postingDesignationRepository.findAll());
            return "pims/lookup/postingdesignation";
        }
        postingDesignationRepository.save(postingDesignation);
        return "redirect:/postingdesignation/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id,  PostingDesignation postingDesignation) {
        postingDesignationRepository.deleteById(id);
        return "redirect:/postingdesignation/index";
    }

}
