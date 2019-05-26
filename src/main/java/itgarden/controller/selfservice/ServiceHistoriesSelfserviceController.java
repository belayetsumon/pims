/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.ServiceHistories;
import itgarden.model.Users;
import itgarden.repository.ServiceHistoriesRepository;
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
@RequestMapping("/selfservice_servicehistories")
public class ServiceHistoriesSelfserviceController {

    @Autowired
    ServiceHistoriesRepository serviceHistoriesRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, ServiceHistories serviceHistories) {

        Users users = new Users();

        users.setId(e_id);

        serviceHistories.setGovernmentId(users);

        model.addAttribute("list", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/servicehistories";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, ServiceHistories serviceHistories) {

        model.addAttribute("serviceHistories", serviceHistoriesRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        serviceHistories.setGovernmentId(users);

        model.addAttribute("list", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/servicehistories";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid ServiceHistories serviceHistories, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            serviceHistories.setGovernmentId(users);

            model.addAttribute("list", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/selfservice/servicehistories";
        }
        serviceHistories.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        serviceHistories.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());

        serviceHistoriesRepository.save(serviceHistories);
        return "redirect:/selfservice_servicehistories/index/{e_id}";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, ServiceHistories serviceHistories, RedirectAttributes redirectAttrs) {

        serviceHistories = serviceHistoriesRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", serviceHistories.getGovernmentId());

        serviceHistoriesRepository.deleteById(id);

        return "redirect:/selfservice_servicehistories/index/{e_id}";
    }

}
