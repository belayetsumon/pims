/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.RetirementPension;
import itgarden.model.Users;
import itgarden.model.enumvalue.Retirement;
import itgarden.repository.RetirementPensionRepository;
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
@RequestMapping("/retirementpension")
public class RetirementPensionController {

    @Autowired
    RetirementPensionRepository retirementPensionRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, RetirementPension retirementPension) {

        Users users = new Users();

        users.setId(e_id);

        retirementPension.setGovernmentId(users);

        model.addAttribute("list", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("retirementtype", Retirement.values());

        return "pims/retirementpension/retirementpension";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, RetirementPension retirementPension) {
        model.addAttribute("retirementPension", retirementPensionRepository.getOne(id));
        Users users = new Users();

        users.setId(id);

        retirementPension.setGovernmentId(users);

        model.addAttribute("list", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("retirementtype", Retirement.values());

        return "pims/retirementpension/retirementpension";
    }

    @RequestMapping("/save/{e_id}")

    public String save(Model model, @PathVariable Long e_id, @Valid RetirementPension retirementPension, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            retirementPension.setGovernmentId(users);
            model.addAttribute("list", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("retirementtype", Retirement.values());
            return "pims/retirementpension/retirementpension";
        }
        retirementPension.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        retirementPension.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        retirementPensionRepository.save(retirementPension);
        return "redirect:/retirementpension/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, RetirementPension retirementPension, RedirectAttributes redirectAttrs) {

        retirementPension = retirementPensionRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", retirementPension.getGovernmentId());

        retirementPensionRepository.deleteById(id);

        return "redirect:/retirementpension/index/{e_id}";
    }

}
