/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.FirstJoiningInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.enumvalue.Selectiongrade;
import itgarden.repository.FirstJoiningInformationRepository;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PresentPostingLocationRepository;
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
@RequestMapping("/selfservice_firstjoininginformation")
public class FirstJoiningInformationSelfserviceController {

    @Autowired
    FirstJoiningInformationRepository firstJoiningInformationRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, FirstJoiningInformation firstJoiningInformation) {

        Users users = new Users();

        users.setId(e_id);

        firstJoiningInformation.setGovernmentId(users);

        model.addAttribute("list", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("postingType", PostingType.values());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("firstPostingDesignation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/selfservice/firstjoininginformation";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, FirstJoiningInformation firstJoiningInformation) {
        model.addAttribute("firstJoiningInformation", firstJoiningInformationRepository.getOne(id));
        Users users = new Users();

        users.setId(id);

        firstJoiningInformation.setGovernmentId(users);

        model.addAttribute("list", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("postingType", PostingType.values());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("firstPostingDesignation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/selfservice/firstjoininginformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid FirstJoiningInformation firstJoiningInformation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            firstJoiningInformation.setGovernmentId(users);
            model.addAttribute("list", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("postingType", PostingType.values());
            model.addAttribute("postingrank", postingRankRepository.findAll());
            model.addAttribute("firstPostingDesignation", postingDesignationRepository.findAll());
            model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());
            model.addAttribute("grade", Selectiongrade.values());
            return "pims/selfservice/firstjoininginformation";
        }
        firstJoiningInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        firstJoiningInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        firstJoiningInformationRepository.save(firstJoiningInformation);
        return "redirect:/selfservice_firstjoininginformation/index/{e_id}";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, FirstJoiningInformation firstJoiningInformation, RedirectAttributes redirectAttrs) {

        firstJoiningInformation = firstJoiningInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", firstJoiningInformation.getGovernmentId());

        firstJoiningInformationRepository.deleteById(id);

        return "redirect:/selfservice_firstjoininginformation/index/{e_id}";

    }

}
