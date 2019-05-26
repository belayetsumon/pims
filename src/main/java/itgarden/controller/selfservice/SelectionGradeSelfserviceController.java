/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.SelectionGrade;
import itgarden.model.Users;
import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.enumvalue.PromotionNature;
import itgarden.model.enumvalue.Selectiongrade;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PresentPostingLocationRepository;
import itgarden.repository.SelectionGradeRepository;
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
@RequestMapping("/selfservice_selectiongrade")
public class SelectionGradeSelfserviceController {

    @Autowired
    SelectionGradeRepository selectionGradeRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, SelectionGrade selectionGrade) {
        Users users = new Users();

        users.setId(e_id);

        selectionGrade.setGovernmentId(users);

        model.addAttribute("list", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("bcountry", BirthCountry.values());

        model.addAttribute("postingtype", PostingType.values());

        model.addAttribute("promotionnature", PromotionNature.values());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/selfservice/selectiongrade";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, SelectionGrade selectionGrade) {

        model.addAttribute("selectionGrade", selectionGradeRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        selectionGrade.setGovernmentId(users);

        model.addAttribute("list", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingrank", postingRankRepository.findAll());

        model.addAttribute("bcountry", BirthCountry.values());

        model.addAttribute("postingtype", PostingType.values());

        model.addAttribute("promotionnature", PromotionNature.values());

        model.addAttribute("grade", Selectiongrade.values());

        return "pims/selfservice/selectiongrade";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid SelectionGrade selectionGrade, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            selectionGrade.setGovernmentId(users);

            model.addAttribute("list", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));

            model.addAttribute("designation", postingDesignationRepository.findAll());

            model.addAttribute("postinglocation", presentPostingLocationRepository.findAll());

            model.addAttribute("postingrank", postingRankRepository.findAll());

            model.addAttribute("bcountry", BirthCountry.values());

            model.addAttribute("postingtype", PostingType.values());

            model.addAttribute("promotionnature", PromotionNature.values());

            model.addAttribute("grade", Selectiongrade.values());

            return "pims/selfservice/selectiongrade";
        }
        selectionGrade.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        selectionGrade.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        selectionGradeRepository.save(selectionGrade);

        return "redirect:/selfservice_selectiongrade/index/{e_id}";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, SelectionGrade selectionGrade, RedirectAttributes redirectAttrs) {

        selectionGrade = selectionGradeRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", selectionGrade.getGovernmentId());

        selectionGradeRepository.deleteById(id);

        return "redirect:/selfservice_selectiongrade/index/{e_id}";
    }

}
