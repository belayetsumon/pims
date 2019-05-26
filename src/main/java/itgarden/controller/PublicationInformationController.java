/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.PublicationInformation;
import itgarden.model.Users;
import itgarden.repository.PublicationInformationRepository;
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
@RequestMapping("/publication")
public class PublicationInformationController {

    @Autowired
    PublicationInformationRepository publicationInformationRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, PublicationInformation publicationInformation) {

        Users users = new Users();

        users.setId(e_id);

        publicationInformation.setGovernmentId(users);

        model.addAttribute("list", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/publication/publication";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, PublicationInformation publicationInformation) {

        model.addAttribute("publicationInformation", publicationInformationRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        publicationInformation.setGovernmentId(users);

        model.addAttribute("list", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/publication/publication";

    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid PublicationInformation publicationInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            Users users = new Users();

            users.setId(e_id);

            publicationInformation.setGovernmentId(users);

            model.addAttribute("list", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/publication/publication";
        }

        publicationInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        publicationInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());

        publicationInformationRepository.save(publicationInformation);

        return "redirect:/publication/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, PublicationInformation publicationInformation, RedirectAttributes redirectAttrs) {

        publicationInformation = publicationInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", publicationInformation.getGovernmentId());

        publicationInformationRepository.deleteById(id);

        return "redirect:/publication/index/{e_id}";
    }

}
