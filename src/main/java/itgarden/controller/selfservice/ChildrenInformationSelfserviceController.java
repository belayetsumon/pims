/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.ChildrenInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.EthnicIdentity;
import itgarden.model.enumvalue.Gender;
import itgarden.model.enumvalue.MaritalStatus;
import itgarden.model.enumvalue.PsychicalStatus;
import itgarden.model.enumvalue.YesNo;
import itgarden.repository.ChildrenInformationRepository;
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
@RequestMapping("/selfservice_childreninformation")
public class ChildrenInformationSelfserviceController {

    @Autowired
    ChildrenInformationRepository childrenInformationRepository;

  

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, ChildrenInformation childrenInformation) {
        Users users = new Users();
        users.setId(e_id);
        childrenInformation.setGovernmentId(users);
        model.addAttribute("list", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("gender", Gender.values());
        model.addAttribute("psychicalStatus", PsychicalStatus.values());
        model.addAttribute("yesno", YesNo.values());
        model.addAttribute("maritalStatus", MaritalStatus.values());
        model.addAttribute("birthcountry", BirthCountry.values());
        model.addAttribute("ethnicIdentitys", EthnicIdentity.values());
        return "pims/selfservice/childreninformation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, ChildrenInformation childrenInformation) {
        model.addAttribute("childrenInformation", childrenInformationRepository.getOne(id));
        Users users = new Users();
        users.setId(id);
        childrenInformation.setGovernmentId(users);
        model.addAttribute("list", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("gender", Gender.values());
        model.addAttribute("psychicalStatus", PsychicalStatus.values());
        model.addAttribute("yesno", YesNo.values());
        model.addAttribute("maritalStatus", MaritalStatus.values());
        model.addAttribute("birthcountry", BirthCountry.values());
        model.addAttribute("ethnicIdentitys", EthnicIdentity.values());
        return "pims/selfservice/childreninformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid ChildrenInformation childrenInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            childrenInformation.setGovernmentId(users);
            model.addAttribute("list", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("gender", Gender.values());
            model.addAttribute("psychicalStatus", PsychicalStatus.values());
            model.addAttribute("yesno", YesNo.values());
            model.addAttribute("maritalStatus", MaritalStatus.values());
            model.addAttribute("birthcountry", BirthCountry.values());
            model.addAttribute("ethnicIdentitys", EthnicIdentity.values());
            return "pims/selfservice/childreninformation";

        }

        childrenInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        childrenInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());

        childrenInformationRepository.save(childrenInformation);
        return "redirect:/selfservice_childreninformation/index/{e_id}";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, ChildrenInformation childrenInformation, RedirectAttributes redirectAttrs) {
        childrenInformation = childrenInformationRepository.getOne(id);
        redirectAttrs.addAttribute("e_id", childrenInformation.getGovernmentId());
        childrenInformationRepository.deleteById(id);
        return "redirect:/selfservice_childreninformation/index/{e_id}";
    }

}
