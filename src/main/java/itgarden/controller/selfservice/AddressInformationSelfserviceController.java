/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.AddressInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.AddressType;
import itgarden.model.enumvalue.District;
import itgarden.repository.AddressInformationRepository;
import itgarden.repository.ThanaRepository;
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
@RequestMapping("/selfservice_addressinformation")
public class AddressInformationSelfserviceController {

    @Autowired
    AddressInformationRepository addressInformationRepository;

    @Autowired
    ThanaRepository thanaRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, AddressInformation addressInformation) {
        Users users = new Users();
        users.setId(e_id);

        addressInformation.setGovernmentId(users);

        model.addAttribute("list", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("district", District.values());

        model.addAttribute("thana", thanaRepository.findAll());

        model.addAttribute("addresstype", AddressType.values());

        return "pims/selfservice/addressinformation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, AddressInformation addressInformation) {
        model.addAttribute("addressInformation", addressInformationRepository.getOne(id));
        Users users = new Users();
        users.setId(id);

        addressInformation.setGovernmentId(users);

        model.addAttribute("list", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("district", District.values());

        model.addAttribute("thana", thanaRepository.findAll());

        model.addAttribute("addresstype", AddressType.values());

        return "pims/selfservice/addressinformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid AddressInformation addressInformation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);

            addressInformation.setGovernmentId(users);

            model.addAttribute("list", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));

            model.addAttribute("district", District.values());

            model.addAttribute("thana", thanaRepository.findAll());

            model.addAttribute("addresstype", AddressType.values());

            return "pims/selfservice/addressinformation";

        }

        addressInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());

        addressInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());

        addressInformationRepository.save(addressInformation);
        return "redirect:/selfservice_addressinformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, AddressInformation addressInformation, RedirectAttributes redirectAttrs) {

       addressInformation = addressInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", addressInformation.getGovernmentId());

        addressInformationRepository.deleteById(id);

        return "redirect:/selfservice_addressinformation/index/{e_id}";
    }

}
