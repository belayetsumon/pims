/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.InServiceTrainingInformation;
import itgarden.model.MagisterialPower;
import itgarden.model.Users;
import itgarden.model.enumvalue.Magisterial_Power;
import itgarden.repository.MagisterialPowerRepository;
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
@RequestMapping("/magisterialpower")
@PreAuthorize("hasAuthority('magisterialpower')")
public class MagisterialPowerController {

    @Autowired
    MagisterialPowerRepository magisterialPowerRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, MagisterialPower magisterialPower) {
        Users users = new Users();

        users.setId(e_id);

        magisterialPower.setGovernmentId(users);

        model.addAttribute("list", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterial_power", Magisterial_Power.values());
        return "pims/magisterialpower/magisterialpower";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, MagisterialPower magisterialPower) {
        model.addAttribute("magisterial_power", magisterialPowerRepository.getOne(id));
        Users users = new Users();

        users.setId(id);

        magisterialPower.setGovernmentId(users);

        model.addAttribute("list", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("magisterial_power", Magisterial_Power.values());

        return "pims/magisterialpower/magisterialpower";
    }

    @RequestMapping("/save/{e_id}")

    public String save(Model model, @PathVariable Long e_id, @Valid MagisterialPower magisterialPower, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            magisterialPower.setGovernmentId(users);

            model.addAttribute("list", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));

            model.addAttribute("magisterial_power", Magisterial_Power.values());

            return "pims/magisterialpower/magisterialpower";
        }

        magisterialPower.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        magisterialPower.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        magisterialPowerRepository.save(magisterialPower);

        return "redirect:/magisterialpower/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, MagisterialPower magisterialPower, RedirectAttributes redirectAttrs) {

        magisterialPower = magisterialPowerRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", magisterialPower.getGovernmentId());

        magisterialPowerRepository.deleteById(id);

        return "redirect:/magisterialpower/index/{e_id}";
    }

}
