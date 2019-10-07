/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.DisciplinaryActionDetails;
import itgarden.model.Users;
import itgarden.repository.DisciplinaryActionDetailsRepository;
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
@RequestMapping("/disciplinaryaction")
@PreAuthorize("hasAuthority('disciplinaryaction')")
public class DisciplinaryActionController {

    @Autowired
    DisciplinaryActionDetailsRepository disciplinaryActionDetailsRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, DisciplinaryActionDetails disciplinaryActionDetails) {

        Users users = new Users();

        users.setId(e_id);

        disciplinaryActionDetails.setGovernmentId(users);

        model.addAttribute("list", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/disciplinaryaction/disciplinaryaction";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, DisciplinaryActionDetails disciplinaryActionDetails) {

        model.addAttribute("disciplinaryActionDetails", disciplinaryActionDetailsRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        disciplinaryActionDetails.setGovernmentId(users);

        model.addAttribute("list", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/disciplinaryaction/disciplinaryaction";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid DisciplinaryActionDetails disciplinaryActionDetails, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            Users users = new Users();

            users.setId(e_id);

            disciplinaryActionDetails.setGovernmentId(users);

            model.addAttribute("list", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/disciplinaryaction/disciplinaryaction";
        }
        
        disciplinaryActionDetails.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        disciplinaryActionDetails.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        disciplinaryActionDetailsRepository.save(disciplinaryActionDetails);

        return "redirect:/disciplinaryaction/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, DisciplinaryActionDetails disciplinaryActionDetails, RedirectAttributes redirectAttrs) {
        disciplinaryActionDetails = disciplinaryActionDetailsRepository.getOne(id);
        redirectAttrs.addAttribute("e_id", disciplinaryActionDetails.getGovernmentId());
        disciplinaryActionDetailsRepository.deleteById(id);
        return "redirect:/disciplinaryaction/index/{e_id}";
    }

}
