/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.PostingRecordInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.PostingReason;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.enumvalue.Selectiongrade;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PostingRecordInformationRepository;
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
@RequestMapping("/selfservice_postingrecordinformation")
@PreAuthorize("hasAuthority('selfservice_postingabroadinformation')")
public class PostingRecordInformationSelfserviceController {

    @Autowired
    PostingRecordInformationRepository postingRecordInformationRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, PostingRecordInformation postingRecordInformation) {
        Users users = new Users();
        users.setId(e_id);
        postingRecordInformation.setGovernmentId(users);

        model.addAttribute("list", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("bcountry", BirthCountry.values());

        model.addAttribute("postingtype", PostingType.values());

        model.addAttribute("postingreason", PostingReason.values());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/selfservice/postingrecordinformation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, PostingRecordInformation postingRecordInformation) {
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.getOne(id));
        Users users = new Users();

        users.setId(id);

        postingRecordInformation.setGovernmentId(users);

        model.addAttribute("list", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("bcountry", BirthCountry.values());

        model.addAttribute("postingtype", PostingType.values());

        model.addAttribute("postingreason", PostingReason.values());

        model.addAttribute("grade", Selectiongrade.values());
        return "pims/selfservice/postingrecordinformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid PostingRecordInformation postingRecordInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            postingRecordInformation.setGovernmentId(users);

            model.addAttribute("list", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("designation", postingDesignationRepository.findAll());

            model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

            model.addAttribute("postingrank", postingRankRepository.findAll());

            model.addAttribute("bcountry", BirthCountry.values());

            model.addAttribute("postingtype", PostingType.values());

            model.addAttribute("postingreason", PostingReason.values());

            model.addAttribute("grade", Selectiongrade.values());
            return "pims/selfservice/postingrecordinformation";
        }
        postingRecordInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        postingRecordInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        
        postingRecordInformationRepository.save(postingRecordInformation);
        return "redirect:/selfservice_postingrecordinformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, PostingRecordInformation postingRecordInformation, RedirectAttributes redirectAttrs) {

        postingRecordInformation = postingRecordInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", postingRecordInformation.getGovernmentId());

        postingRecordInformationRepository.deleteById(id);

        return "redirect:/selfservice_postingrecordinformation/index/{e_id}";
    }
}
