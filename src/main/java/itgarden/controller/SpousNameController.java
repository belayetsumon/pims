/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.SpousName;
import itgarden.model.Users;
import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.District;
import itgarden.model.enumvalue.EthnicIdentity;
import itgarden.repository.SpousNameRepository;
import itgarden.service.LoggedUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/spouse")
@PreAuthorize("hasAuthority('spouse')")
public class SpousNameController {

    @Autowired
    SpousNameRepository spousNameRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, SpousName spousName) {
        Users users = new Users();
        users.setId(e_id);
        spousName.setGovernmentId(users);
        model.addAttribute("list", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("birthcountry", BirthCountry.values());
        model.addAttribute("ethnicIdentitys", EthnicIdentity.values());
        model.addAttribute("districts", District.values());
        return "pims/spouse/spouse";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, SpousName spousName) {

        model.addAttribute("spousName", spousNameRepository.getOne(id));
        Users users = new Users();
        users.setId(id);
        spousName.setGovernmentId(users);
        model.addAttribute("list", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("birthcountry", BirthCountry.values());
        model.addAttribute("ethnicIdentitys", EthnicIdentity.values());
        model.addAttribute("districts", District.values());
        return "pims/spouse/spouse";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid SpousName spousName, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            spousName.setGovernmentId(users);
            model.addAttribute("list", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("birthcountry", BirthCountry.values());
            model.addAttribute("ethnicIdentitys", EthnicIdentity.values());
            model.addAttribute("districts", District.values());
            return "pims/spouse/spouse";
        }

        spousName.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        spousName.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        spousNameRepository.save(spousName);
        return "redirect:/spouse/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, SpousName spousName, RedirectAttributes redirectAttrs) {
        spousName = spousNameRepository.getOne(id);
        redirectAttrs.addAttribute("e_id", spousName.getGovernmentId());
        spousNameRepository.deleteById(id);
        return "redirect:/spouse/index/{e_id}";
    }

}
