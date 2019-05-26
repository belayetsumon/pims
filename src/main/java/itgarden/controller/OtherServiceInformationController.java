/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.OtherServiceInformation;
import itgarden.model.Users;
import itgarden.repository.OtherServiceInformationRepository;
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
@RequestMapping("/otherserviceinformation")
public class OtherServiceInformationController {

    @Autowired
    OtherServiceInformationRepository otherServiceInformationRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, OtherServiceInformation otherServiceInformation) {
        Users users = new Users();
        users.setId(e_id);
        otherServiceInformation.setGovernmentId(users);

        model.addAttribute("list", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/otherserviceinformation/otherserviceinformation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, OtherServiceInformation otherServiceInformation) {

        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.getOne(id));
        Users users = new Users();
        users.setId(id);
        otherServiceInformation.setGovernmentId(users);

        model.addAttribute("list", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/otherserviceinformation/otherserviceinformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid OtherServiceInformation otherServiceInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            otherServiceInformation.setGovernmentId(users);

            model.addAttribute("list", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/otherserviceinformation/otherserviceinformation";
        }

        otherServiceInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        otherServiceInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        
        otherServiceInformationRepository.save(otherServiceInformation);
        return "redirect:/otherserviceinformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, OtherServiceInformation otherServiceInformation, RedirectAttributes redirectAttrs) {

        otherServiceInformation = otherServiceInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", otherServiceInformation.getGovernmentId());

        otherServiceInformationRepository.deleteById(id);

        return "redirect:/otherserviceinformation/index/{e_id}";
    }

}
