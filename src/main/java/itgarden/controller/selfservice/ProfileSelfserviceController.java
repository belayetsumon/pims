/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.Users;
import itgarden.repository.AcrRepository;
import itgarden.repository.AdditionalQualificationRepository;
import itgarden.repository.AddressInformationRepository;
import itgarden.repository.ChildrenInformationRepository;
import itgarden.repository.DisciplinaryActionDetailsRepository;
import itgarden.repository.EducationalInformationRepository;
import itgarden.repository.FirstJoiningInformationRepository;
import itgarden.repository.ForeignTrainingInformationRepository;
import itgarden.repository.GeneralInformationRepository;
import itgarden.repository.HonorsAndAwardInformationRepository;
import itgarden.repository.InServiceTrainingInformationRepository;
import itgarden.repository.JobEntryProcessRepository;
import itgarden.repository.LanguageInformationRepository;
import itgarden.repository.LeaveinfoRepository;
import itgarden.repository.MagisterialPowerRepository;
import itgarden.repository.MembershipRepository;
import itgarden.repository.OtherServiceInformationRepository;
import itgarden.repository.PostingAbroadInformationRepository;
import itgarden.repository.PostingRecordInformationRepository;
import itgarden.repository.PresentJobRepository;
import itgarden.repository.PromotionsInformationRepository;
import itgarden.repository.PublicationInformationRepository;
import itgarden.repository.RetirementPensionRepository;
import itgarden.repository.SelectionGradeRepository;
import itgarden.repository.ServiceHistoriesRepository;
import itgarden.repository.SpousNameRepository;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller

@RequestMapping("/selfservice")
@PreAuthorize("hasAuthority('selfservice')")
public class ProfileSelfserviceController {

    @Autowired
    AdditionalQualificationRepository additionalQualificationRepository;

    @Autowired
    AddressInformationRepository addressInformationRepository;

    @Autowired
    ChildrenInformationRepository childrenInformationRepository;

    @Autowired
    DisciplinaryActionDetailsRepository disciplinaryActionDetailsRepository;

    @Autowired
    EducationalInformationRepository educationalInformationRepository;

    @Autowired
    GeneralInformationRepository generalInformationRepository;

    @Autowired
    HonorsAndAwardInformationRepository honorsAndAwardInformationRepository;

    @Autowired
    ForeignTrainingInformationRepository foreignTrainingInformationRepository;

    @Autowired
    InServiceTrainingInformationRepository inServiceTrainingInformationRepository;

    @Autowired
    LanguageInformationRepository languageInformationRepository;

    @Autowired
    MagisterialPowerRepository magisterialPowerRepository;

    @Autowired
    OtherServiceInformationRepository otherServiceInformationRepository;
    @Autowired
    PostingAbroadInformationRepository postingAbroadInformationRepository;

    @Autowired
    PostingRecordInformationRepository postingRecordInformationRepository;

    @Autowired
    PromotionsInformationRepository promotionsInformationRepository;

    @Autowired
    PublicationInformationRepository publicationInformationRepository;

    @Autowired
    SelectionGradeRepository selectionGradeRepository;

    @Autowired
    ServiceHistoriesRepository serviceHistoriesRepository;

    @Autowired
    SpousNameRepository spousNameRepository;

    @Autowired
    JobEntryProcessRepository jobEntryProcessRepository;

    @Autowired
    FirstJoiningInformationRepository firstJoiningInformationRepository;

    @Autowired
    PresentJobRepository presentJobRepository;

    @Autowired
    LeaveinfoRepository leaveinfoRepository;

    @Autowired
    AcrRepository acrRepository;

    @Autowired
    RetirementPensionRepository retirementPensionRepository;

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")

    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = usersRepository.findByGovernmentId(auth.getName());
        model.addAttribute("employee", usersRepository.getOne(users.getId()));
        return "pims/selfservice/index";
    }
    
    @RequestMapping("/fullprofile/{e_id}")
    public String fullprofile(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        return "pims/selfservice/fullprofile";
    }
@RequestMapping("/createprofilepdf/{e_id}")
    public String createprofilepdf(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        
        return "pims/selfservice/fullprofilePrint";
    }
    
    
    
    
    @RequestMapping("/shortprofile/{e_id}")
    public String shortprofile(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        return "pims/profile/short_profile";
    }

    @RequestMapping("/longprofile/{e_id}")
    public String longprofile(Model model, @PathVariable Long e_id) {
        Users users = new Users();
        users.setId(e_id);
        model.addAttribute("employee", usersRepository.getOne(e_id));
        model.addAttribute("additionalQualification", additionalQualificationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("addressInformation", addressInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("childrenInformation", childrenInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("disciplinaryAction", disciplinaryActionDetailsRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("educationalInformation", educationalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("foreignTrainingInformation", foreignTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("generalInformation", generalInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("honorsAndAwardInformation", honorsAndAwardInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("inServiceTrainingInformation", inServiceTrainingInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("languageInformation", languageInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("magisterialPower", magisterialPowerRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("otherServiceInformation", otherServiceInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingAbroadInformation", postingAbroadInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("postingRecordInformation", postingRecordInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("promotionsInformation", promotionsInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("publicationInformation", publicationInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("selectionGrade", selectionGradeRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("serviceHistories", serviceHistoriesRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("jobentryprocess", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("firstjoininginformation", firstJoiningInformationRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("presentjob", presentJobRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leaveinfo", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("membership", membershipRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("acr", acrRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("retirementpension", retirementPensionRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("spousName", spousNameRepository.findByGovernmentIdOrderByIdDesc(users));
        return "pims/profile/longprofile";
    }
    
    
 }
