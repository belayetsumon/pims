/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.HonorsAndAwardInformation;
import itgarden.model.Users;
import itgarden.repository.HonorsAndAwardInformationRepository;
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
@RequestMapping("/selfservice_honorsandawardinformation")
@PreAuthorize("hasAuthority('selfservice_honorsandawardinformation')")
public class HonorsAndAwardInformationSelfserviceController {

    @Autowired
    HonorsAndAwardInformationRepository honorsAndAwardInformationRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, HonorsAndAwardInformation honorsAndAwardInformation) {

        Users users = new Users();

        users.setId(e_id);

        honorsAndAwardInformation.setGovernmentId(users);

        model.addAttribute("list", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/honorsandawardinformation";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, HonorsAndAwardInformation honorsAndAwardInformation) {

        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        honorsAndAwardInformation.setGovernmentId(users);

        model.addAttribute("list", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/honorsandawardinformation";

    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid HonorsAndAwardInformation honorsAndAwardInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            honorsAndAwardInformation.setGovernmentId(users);

            model.addAttribute("list", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/selfservice/honorsandawardinformation";

        }

        honorsAndAwardInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        honorsAndAwardInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        honorsAndAwardInformationRepository.save(honorsAndAwardInformation);
        return "redirect:/selfservice_honorsandawardinformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, HonorsAndAwardInformation honorsAndAwardInformation, RedirectAttributes redirectAttrs) {

        honorsAndAwardInformation = honorsAndAwardInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", honorsAndAwardInformation.getGovernmentId());

        honorsAndAwardInformationRepository.deleteById(id);

        return "redirect:/selfservice_honorsandawardinformation/index/{e_id}";
    }

}
