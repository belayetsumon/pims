/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.PresentJob;
import itgarden.model.Users;
import itgarden.model.enumvalue.PostingReason;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.enumvalue.Selectiongrade;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PresentJobRepository;
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
@RequestMapping("/presentjob")
public class PresentJobController {

    @Autowired
    PresentJobRepository presentJobRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String Index(Model model, @PathVariable Long e_id, PresentJob presentJob) {

        Users users = new Users();

        users.setId(e_id);

        presentJob.setGovernmentId(users);

        model.addAttribute("list", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("postingType", PostingType.values());

        model.addAttribute("postingreason", PostingReason.values());

        model.addAttribute("firstPostingDesignation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/presentjob/presentjob";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, PresentJob presentJob) {

        model.addAttribute("presentJob", presentJobRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        presentJob.setGovernmentId(users);

        model.addAttribute("list", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("postingType", PostingType.values());
        model.addAttribute("postingreason", PostingReason.values());

        model.addAttribute("firstPostingDesignation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/presentjob/presentjob";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid PresentJob presentJob, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            Users users = new Users();

            users.setId(e_id);

            presentJob.setGovernmentId(users);

            model.addAttribute("list", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));

            model.addAttribute("postingType", PostingType.values());
            model.addAttribute("postingreason", PostingReason.values());

            model.addAttribute("firstPostingDesignation", postingDesignationRepository.findAll());

            model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

            model.addAttribute("postingrank", postingRankRepository.findAll());

            model.addAttribute("grade", Selectiongrade.values());

            return "pims/presentjob/presentjob";
        }
        presentJobRepository.save(presentJob);
        return "redirect:/presentjob/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, PresentJob presentJob, RedirectAttributes redirectAttrs) {

        presentJob = presentJobRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", presentJob.getGovernmentId());

        presentJobRepository.deleteById(id);

        return "redirect:/presentjob/index/{e_id}";

    }

}
