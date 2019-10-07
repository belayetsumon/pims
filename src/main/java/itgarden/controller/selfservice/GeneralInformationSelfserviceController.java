/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.GeneralInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.BloodGroup;
import itgarden.model.enumvalue.District;
import itgarden.model.enumvalue.EmployeeStatus;
import itgarden.model.enumvalue.EthnicIdentity;
import itgarden.model.enumvalue.Gender;
import itgarden.model.enumvalue.MaritalStatus;
import itgarden.model.enumvalue.Religion;
import itgarden.repository.BatchRepository;
import itgarden.repository.CadreRepository;
import itgarden.repository.GeneralInformationRepository;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingOrganizationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PresentPostingLocationRepository;
import itgarden.repository.UsersRepository;
import itgarden.service.LoggedUserService;
import java.util.Optional;
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
@RequestMapping("/selfservice_generalinformation")
@PreAuthorize("hasAuthority('selfservice_generalinformation')")
//@Transactional( propagation = Propagation.SUPPORTS,readOnly = true )
public class GeneralInformationSelfserviceController {

    @Autowired
    GeneralInformationRepository generalInformationRepository;

    @Autowired
    BatchRepository batchRepository;

    @Autowired
    CadreRepository cadreRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PostingOrganizationRepository postingOrganizationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, GeneralInformation generalInformation) {

        model.addAttribute("list", generalInformationRepository.findAll());

        model.addAttribute("gender", Gender.values());

        model.addAttribute("district", District.values());

        model.addAttribute("batch", batchRepository.findAll());

        model.addAttribute("cadre", cadreRepository.findAll());

        model.addAttribute("employeestatus", EmployeeStatus.values());

        model.addAttribute("ethnicIdentitys", EthnicIdentity.values());

        model.addAttribute("postingDesignation", postingDesignationRepository.findAll());

        model.addAttribute("postingOrganization", postingOrganizationRepository.findAll());

        model.addAttribute("presentPostingLocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingRank", postingRankRepository.findAll());

        model.addAttribute("bloodgroups", BloodGroup.values());

        model.addAttribute("birthcountry", BirthCountry.values());

        model.addAttribute("maritalStatus", MaritalStatus.values());

        model.addAttribute("religion", Religion.values());

        model.addAttribute("employee", usersRepository.findById(e_id));

        Users users = new Users();
        users.setId(e_id);

        model.addAttribute("list", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        generalInformation.setGovernmentId(users);

        Optional<Users> username = usersRepository.findById(e_id);
        
        generalInformation.setName(username.get().getName());

        return "pims/selfservice/generalinformation";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, GeneralInformation generalInformation) {

        model.addAttribute("generalInformation", generalInformationRepository.getOne(id));
        
        

        model.addAttribute("list", generalInformationRepository.findAll());

        model.addAttribute("gender", Gender.values());

        model.addAttribute("district", District.values());

        model.addAttribute("batch", batchRepository.findAll());

        model.addAttribute("cadre", cadreRepository.findAll());

        model.addAttribute("employeestatus", EmployeeStatus.values());

        model.addAttribute("ethnicIdentitys", EthnicIdentity.values());

        model.addAttribute("postingDesignation", postingDesignationRepository.findAll());

        model.addAttribute("postingOrganization", postingOrganizationRepository.findAll());
        model.addAttribute("presentPostingLocation", presentPostingLocationRepository.findAll());

        model.addAttribute("postingRank", postingRankRepository.findAll());

        model.addAttribute("bloodgroups", BloodGroup.values());

        model.addAttribute("birthcountry", BirthCountry.values());

        model.addAttribute("maritalStatus", MaritalStatus.values());

        model.addAttribute("religion", Religion.values());
        model.addAttribute("employee", usersRepository.findById(id));

        return "pims/selfservice/generalinformation";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid GeneralInformation generalInformation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("list", generalInformationRepository.findAll());

            model.addAttribute("gender", Gender.values());

            model.addAttribute("district", District.values());

            model.addAttribute("batch", batchRepository.findAll());

            model.addAttribute("cadre", cadreRepository.findAll());

            model.addAttribute("employeestatus", EmployeeStatus.values());

            model.addAttribute("ethnicIdentitys", EthnicIdentity.values());

            model.addAttribute("postingDesignation", postingDesignationRepository.findAll());

            model.addAttribute("postingOrganization", postingOrganizationRepository.findAll());

            model.addAttribute("presentPostingLocation", presentPostingLocationRepository.findAll());

            model.addAttribute("postingRank", postingRankRepository.findAll());

            model.addAttribute("bloodgroups", BloodGroup.values());

            model.addAttribute("birthcountry", BirthCountry.values());

            model.addAttribute("maritalStatus", MaritalStatus.values());

            model.addAttribute("religion", Religion.values());

            model.addAttribute("employee", usersRepository.getOne(e_id));

            Users users = new Users();
            users.setId(e_id);

            generalInformation.setGovernmentId(users);
           users = usersRepository.getOne(e_id);
            generalInformation.setName(generalInformation.getName());
            return "pims/selfservice/generalinformation";
        }
        generalInformation.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        generalInformation.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        generalInformationRepository.save(generalInformation);
        return "redirect:/selfservice_generalinformation/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, GeneralInformation generalInformation, RedirectAttributes redirectAttrs) {

        generalInformation = generalInformationRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", generalInformation.getGovernmentId());

        generalInformationRepository.deleteById(id);

        return "redirect:/selfservice_generalinformation/index/{e_id}";
    }

}
