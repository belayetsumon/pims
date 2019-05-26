/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.LanguageInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.LanguageName;
import itgarden.model.enumvalue.LanguageSkill;
import itgarden.model.enumvalue.Proficiency;
import itgarden.repository.LanguageInformationRepository;
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
@RequestMapping("/selfservice_language")
public class LanguageInformationSelfserviceController {

    @Autowired
    LanguageInformationRepository languageInformationRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, LanguageInformation languageInformation) {

        Users users = new Users();
        users.setId(e_id);
        languageInformation.setGovernmentId(users);

        model.addAttribute("list", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("languagename", LanguageName.values());
        model.addAttribute("languageskill", LanguageSkill.values());
        model.addAttribute("proficiencys", Proficiency.values());

        return "pims/selfservice/language";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, LanguageInformation languageInformation) {

        model.addAttribute("languageInformation", languageInformationRepository.getOne(id));
        Users users = new Users();
        users.setId(id);
        languageInformation.setGovernmentId(users);

        model.addAttribute("list", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languagename", LanguageName.values());
        model.addAttribute("languageskill", LanguageSkill.values());
        model.addAttribute("proficiencys", Proficiency.values());

        return "pims/selfservice/language";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid LanguageInformation languageInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            languageInformation.setGovernmentId(users);
            model.addAttribute("list", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("languagename", LanguageName.values());
            model.addAttribute("languageskill", LanguageSkill.values());
            model.addAttribute("proficiencys", Proficiency.values());
            return "pims/selfservice/language";
        }
        languageInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        languageInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());

        languageInformationRepository.save(languageInformation);
        return "redirect:/selfservice_language/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, LanguageInformation languageInformation, RedirectAttributes redirectAttrs) {
        languageInformation = languageInformationRepository.getOne(id);
        redirectAttrs.addAttribute("e_id", languageInformation.getGovernmentId());
        languageInformationRepository.deleteById(id);
        return "redirect:/selfservice_language/index/{e_id}";
    }

}
