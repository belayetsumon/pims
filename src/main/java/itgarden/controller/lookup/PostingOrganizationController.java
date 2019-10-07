/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.PostingOrganization;
import itgarden.repository.PostingOrganizationRepository;
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
@RequestMapping("/postingorganization")
@PreAuthorize("hasAuthority('postingorganization')")
public class PostingOrganizationController {

    @Autowired
    PostingOrganizationRepository postingOrganizationRepository;

    @RequestMapping("/index")
    public String index(Model model, PostingOrganization   postingOrganization) {
        model.addAttribute("list", postingOrganizationRepository.findAll());
        return "pims/lookup/postingorganization";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, PostingOrganization   postingOrganization) {
        model.addAttribute("postingOrganization", postingOrganizationRepository.findById(id));
        model.addAttribute("list", postingOrganizationRepository.findAll());
        return "pims/lookup/postingorganization";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid PostingOrganization   postingOrganization, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", postingOrganizationRepository.findAll());
            return "pims/lookup/postingorganization";
        }
        postingOrganizationRepository.save(postingOrganization);
        return "redirect:/postingorganization/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, PostingOrganization   postingOrganization) {
        postingOrganizationRepository.deleteById(id);
        return "redirect:/postingorganization/index";
    }

}
