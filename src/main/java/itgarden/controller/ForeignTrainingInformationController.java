/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.ForeignTrainingInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.BirthCountry;
import itgarden.repository.ForeignTrainingInformationRepository;
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
@RequestMapping("/foreigntraininginformation")
public class ForeignTrainingInformationController {

    @Autowired
    ForeignTrainingInformationRepository foreignTrainingInformationRepository;
    
     @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, ForeignTrainingInformation foreignTrainingInformation) {
        Users users = new Users();

        users.setId(e_id);

        foreignTrainingInformation.setGovernmentId(users);

        model.addAttribute("list", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
         model.addAttribute("birthcountry", BirthCountry.values());

        return "pims/foreigntraininginformation/foreigntraininginformation";

    }
    
    
    
    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, ForeignTrainingInformation foreignTrainingInformation) {
        
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.getOne(id));
        model.addAttribute("birthcountry", BirthCountry.values());
        
        Users users = new Users();

        users.setId(id);

        foreignTrainingInformation.setGovernmentId(users);

        model.addAttribute("list", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/foreigntraininginformation/foreigntraininginformation";

    }
    
    
    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid  ForeignTrainingInformation foreignTrainingInformation, BindingResult bindingResult) {
       
        if(bindingResult.hasErrors()){
        Users users = new Users();

        users.setId(e_id);

        foreignTrainingInformation.setGovernmentId(users);

        model.addAttribute("list", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("birthcountry", BirthCountry.values());

        return "pims/foreigntraininginformation/foreigntraininginformation";
        

    }
        
        foreignTrainingInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        foreignTrainingInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        
        foreignTrainingInformationRepository.save(foreignTrainingInformation);
         return "redirect:/foreigntraininginformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, ForeignTrainingInformation foreignTrainingInformation, RedirectAttributes redirectAttrs) {

       foreignTrainingInformation = foreignTrainingInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", foreignTrainingInformation.getGovernmentId());

        foreignTrainingInformationRepository.deleteById(id);

       return "redirect:/foreigntraininginformation/index/{e_id}";
    }

}
