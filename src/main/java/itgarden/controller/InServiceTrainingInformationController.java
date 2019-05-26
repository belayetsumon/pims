/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.InServiceTrainingInformation;
import itgarden.model.Users;
import itgarden.repository.InServiceTrainingInformationRepository;
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
@RequestMapping("/inservicetraininginformation")
public class InServiceTrainingInformationController {

    @Autowired
    InServiceTrainingInformationRepository inServiceTrainingInformationRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, InServiceTrainingInformation inServiceTrainingInformation) {
        Users users = new Users();

        users.setId(e_id);

        inServiceTrainingInformation.setGovernmentId(users);

        model.addAttribute("list", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/inservicetraininginformation/inservicetraininginformation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, InServiceTrainingInformation inServiceTrainingInformation) {

        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        inServiceTrainingInformation.setGovernmentId(users);

        model.addAttribute("list", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/inservicetraininginformation/inservicetraininginformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid InServiceTrainingInformation inServiceTrainingInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            inServiceTrainingInformation.setGovernmentId(users);

            model.addAttribute("list", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/inservicetraininginformation/inservicetraininginformation";
        }
        inServiceTrainingInformationRepository.save(inServiceTrainingInformation);
        return "redirect:/inservicetraininginformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, InServiceTrainingInformation inServiceTrainingInformation, RedirectAttributes redirectAttrs) {

        inServiceTrainingInformation = inServiceTrainingInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", inServiceTrainingInformation.getGovernmentId());

        inServiceTrainingInformationRepository.deleteById(id);

        return "redirect:/inservicetraininginformation/index/{e_id}";
    }

}
