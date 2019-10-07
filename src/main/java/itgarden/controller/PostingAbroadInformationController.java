/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.PostingAbroadInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.enumvalue.Selectiongrade;
import itgarden.repository.PostingAbroadInformationRepository;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PresentPostingLocationRepository;
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
@RequestMapping("/postingabroadinformation")
@PreAuthorize("hasAuthority('postingabroadinformation')")
public class PostingAbroadInformationController {

    @Autowired
    PostingAbroadInformationRepository postingAbroadInformationRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")

    public String index(Model model, @PathVariable Long e_id, PostingAbroadInformation postingAbroadInformation) {
        Users users = new Users();
        users.setId(e_id);
        postingAbroadInformation.setGovernmentId(users);

        model.addAttribute("list", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("bcountry", BirthCountry.values());

        model.addAttribute("postingtype", PostingType.values());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/postingabroadinformation/postingabroadinformation";
    }

    @RequestMapping("/edit/{id}")

    public String edit(Model model, @PathVariable Long id, PostingAbroadInformation postingAbroadInformation) {
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.getOne(id));
        Users users = new Users();
        users.setId(id);
        postingAbroadInformation.setGovernmentId(users);
        model.addAttribute("list", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("bcountry", BirthCountry.values());

        model.addAttribute("postingtype", PostingType.values());

        model.addAttribute("grade", Selectiongrade.values());
        return "pims/postingabroadinformation/postingabroadinformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid PostingAbroadInformation postingAbroadInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            postingAbroadInformation.setGovernmentId(users);
            model.addAttribute("list", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("designation", postingDesignationRepository.findAll());

            model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

            model.addAttribute("postingrank", postingRankRepository.findAll());

            model.addAttribute("bcountry", BirthCountry.values());

            model.addAttribute("postingtype", PostingType.values());

            model.addAttribute("grade", Selectiongrade.values());
            return "pims/postingabroadinformation/postingabroadinformation";
        }

        postingAbroadInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        postingAbroadInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        postingAbroadInformationRepository.save(postingAbroadInformation);
        return "redirect:/postingabroadinformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, PostingAbroadInformation postingAbroadInformation, RedirectAttributes redirectAttrs) {
        postingAbroadInformation = postingAbroadInformationRepository.getOne(id);
        redirectAttrs.addAttribute("e_id", postingAbroadInformation.getGovernmentId());
        postingAbroadInformationRepository.deleteById(id);
        return "redirect:/postingabroadinformation/index/{e_id}";
    }

}
