/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.AdditionalQualification;
import itgarden.model.Users;
import itgarden.repository.AdditionalQualificationRepository;
import itgarden.service.LoggedUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/additionalqualification")
public class AdditionalQualificationController {

    @Autowired
    AdditionalQualificationRepository additionalQualificationRepository;
    
        @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, AdditionalQualification additionalQualification) {
        Users users = new Users();
        users.setId(e_id);

        model.addAttribute("list", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));

        additionalQualification.setGovernmentId(users);

        return "pims/additionalqualification/additionalqualification";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, AdditionalQualification additionalQualification) {

        model.addAttribute("additionalQualification", additionalQualificationRepository.getOne(id));
        
        
        Users users = new Users();
        users.setId(id);
        model.addAttribute("list", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        additionalQualification.setGovernmentId(users);
        return "pims/additionalqualification/additionalqualification";

    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid AdditionalQualification additionalQualification, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            model.addAttribute("list", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
            additionalQualification.setGovernmentId(users);
            return "pims/additionalqualification/additionalqualification";
        }
        additionalQualification.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        additionalQualification.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        additionalQualificationRepository.save(additionalQualification);
        return "redirect:/additionalqualification/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, AdditionalQualification additionalQualification, RedirectAttributes redirectAttrs) {
         additionalQualificationRepository.findById(id);
        redirectAttrs.addAttribute("e_id", additionalQualification.getGovernmentId());
        additionalQualificationRepository.getOne(id);
        return "redirect:/additionalqualification/index/{e_id}";
    }

}
