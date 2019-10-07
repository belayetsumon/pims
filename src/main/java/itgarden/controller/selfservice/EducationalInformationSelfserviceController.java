/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.EducationalInformation;
import itgarden.model.Users;
import itgarden.repository.EducationalInformationRepository;
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
@RequestMapping("/selfservice_educationalInformation")
@PreAuthorize("hasAuthority('selfservice_educationalInformation')")
public class EducationalInformationSelfserviceController {

    @Autowired
    EducationalInformationRepository educationalInformationRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, EducationalInformation educationalInformation) {

        Users users = new Users();

        users.setId(e_id);

        educationalInformation.setGovernmentId(users);

        model.addAttribute("list", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/educationalInformation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, EducationalInformation educationalInformation) {

        model.addAttribute("educationalInformation", educationalInformationRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        educationalInformation.setGovernmentId(users);

        model.addAttribute("list", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/educationalInformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid EducationalInformation educationalInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            educationalInformation.setGovernmentId(users);

            model.addAttribute("list", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/selfservice/educationalInformation";

        }
        educationalInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        educationalInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());

        educationalInformationRepository.save(educationalInformation);

        return "redirect:/selfservice_educationalInformation/index/{e_id}";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, EducationalInformation educationalInformation, RedirectAttributes redirectAttrs) {

        educationalInformation = educationalInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", educationalInformation.getGovernmentId());

        educationalInformationRepository.deleteById(id);

        return "redirect:/selfservice_educationalInformation/index/{e_id}";
    }

}
