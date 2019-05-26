/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.Acr;
import itgarden.model.Users;
import itgarden.model.enumvalue.PostingType;
import itgarden.repository.AcrRepository;
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
@RequestMapping("/selfservice_acr")
public class AcrSelfserviceController {

    @Autowired
    AcrRepository acrRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, Acr acr) {

        Users users = new Users();

        users.setId(e_id);

        model.addAttribute("list", acrRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postingtype", PostingType.values());

        acr.setGovernmentId(users);

        return "pims/selfservice/acr";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Acr acr) {
        model.addAttribute("acr", acrRepository.getOne(id));
        Users users = new Users();

        users.setId(id);

        model.addAttribute("list", acrRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postingtype", PostingType.values());

        acr.setGovernmentId(users);

        return "pims/selfservice/acr";

    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid Acr acr, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            model.addAttribute("list", acrRepository.findByGovernmentIdOrderByIdDesc(users));

            model.addAttribute("designation", postingDesignationRepository.findAll());

            model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

            model.addAttribute("postingrank", postingRankRepository.findAll());

            model.addAttribute("designation", postingDesignationRepository.findAll());

            model.addAttribute("postingtype", PostingType.values());
            acr.setGovernmentId(users);
            return "pims/selfservice/acr";
        }
        acr.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        acr.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        acrRepository.save(acr);
        return "redirect:/selfservice_acr/index/{e_id}";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Acr acr, RedirectAttributes redirectAttrs) {

      acr = acrRepository.getOne(id);
        redirectAttrs.addAttribute("e_id", acr.getGovernmentId());
        acrRepository.deleteById(id);
        return "redirect:/selfservice_acr/index/{e_id}";
    }

}
