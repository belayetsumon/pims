/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.report;

import itgarden.report.services.*;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/basicreport")
@PreAuthorize("hasAuthority('basicreport')")
public class BasicReportController {

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
    FirstJoiningInformationRepository firstJoiningInformationRepository;

    @Autowired
    ForeignTrainingInformationRepository foreignTrainingInformationRepository;

    @Autowired
    InServiceTrainingInformationRepository inServiceTrainingInformationRepository;

    @Autowired
    JobEntryProcessRepository jobEntryProcessRepository;

    @Autowired
    LanguageInformationRepository languageInformationRepository;
    @Autowired
    LeaveinfoRepository leaveinfoRepository;

    @Autowired
    MagisterialPowerRepository magisterialPowerRepository;

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    OtherServiceInformationRepository otherServiceInformationRepository;

    @Autowired
    PresentJobRepository presentJobRepository;

    @Autowired
    PostingAbroadInformationRepository postingAbroadInformationRepository;

    @Autowired
    PostingRecordInformationRepository postingRecordInformationRepository;

    @Autowired
    PromotionsInformationRepository promotionsInformationRepository;

    @Autowired
    PublicationInformationRepository publicationInformationRepository;

    @Autowired
    RetirementPensionRepository retirementPensionRepository;

    @Autowired
    SelectionGradeRepository selectionGradeRepository;

    @Autowired
    ServiceHistoriesRepository serviceHistoriesRepository;

    @Autowired
    SpousNameRepository spousNameRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AcrRepository acrRepository;

    @Autowired
    PlrService plrService;

    @Autowired
    PromotionsService promotionsService;

    @RequestMapping("/generalinformation")
    public String generalinformation(Model model) {
        model.addAttribute("list", generalInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/generalinformation";
    }

    @RequestMapping("/addressinformation")
    public String addressinformation(Model model) {
        model.addAttribute("list", addressInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/addressinformation";
    }

    @RequestMapping("/spouse")
    public String spouse(Model model) {
        model.addAttribute("list", spousNameRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/spouse";
    }

    @RequestMapping("/childreninformation")
    public String childreninformation(Model model) {
        model.addAttribute("list", childrenInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/childreninformation";
    }

    @RequestMapping("/educationalInformation")
    public String educationalInformation(Model model) {
        model.addAttribute("list", educationalInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/educationalInformation";
    }

    @RequestMapping("/additionalqualification")
    public String additionalqualification(Model model) {
        model.addAttribute("list", additionalQualificationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/additionalqualification";
    }

    @RequestMapping("/language")
    public String language(Model model) {
        model.addAttribute("list", languageInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/language";
    }

    @RequestMapping("/jobentryprocess")
    public String jobentryprocess(Model model) {
        model.addAttribute("list", jobEntryProcessRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/jobentryprocess";
    }

    @RequestMapping("/firstjoininginformation")
    public String firstjoininginformation(Model model) {
        model.addAttribute("list", firstJoiningInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/firstjoininginformation";
    }

    @RequestMapping("/presentjob")
    public String presentjob(Model model) {
        model.addAttribute("list", presentJobRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/presentjob";
    }

    @RequestMapping("/postingrecordinformation")
    public String postingrecordinformation(Model model) {
        model.addAttribute("list", postingRecordInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/postingrecordinformation";
    }

    @RequestMapping("/promotionsinformation")
    public String promotionsinformation(Model model) {
        model.addAttribute("list", promotionsInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/promotionsinformation";
    }

    @RequestMapping("/magisterialpower")
    public String magisterialpower(Model model) {
        model.addAttribute("list", magisterialPowerRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/magisterialpower";
    }

    @RequestMapping("/selectiongrade")
    public String selectiongrade(Model model) {
        model.addAttribute("list", selectionGradeRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/selectiongrade";
    }

    @RequestMapping("/postingabroadinformation")
    public String postingabroadinformation(Model model) {
        model.addAttribute("list", postingAbroadInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/postingabroadinformation";
    }

    @RequestMapping("/foreigntraininginformation")
    public String foreigntraininginformation(Model model) {
        model.addAttribute("list", foreignTrainingInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/foreigntraininginformation";
    }

    @RequestMapping("/inservicetraininginformation")
    public String inservicetraininginformation(Model model) {
        model.addAttribute("list", inServiceTrainingInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/inservicetraininginformation";
    }

    @RequestMapping("/otherserviceinformation")
    public String otherserviceinformation(Model model) {
        model.addAttribute("list", otherServiceInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/otherserviceinformation";
    }

    @RequestMapping("/honorsandawardinformation")
    public String honorsandawardinformation(Model model) {
        model.addAttribute("list", honorsAndAwardInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/honorsandawardinformation";
    }

    @RequestMapping("/disciplinaryaction")
    public String disciplinaryaction(Model model) {
        model.addAttribute("list", disciplinaryActionDetailsRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/disciplinaryaction";
    }

    @RequestMapping("/leaveinfo")
    public String leaveinfo(Model model) {
        model.addAttribute("list", leaveinfoRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/leaveinfo";
    }

    @RequestMapping("/publication")
    public String publication(Model model) {
        model.addAttribute("list", publicationInformationRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/publication";
    }

    @RequestMapping("/membership")
    public String membership(Model model) {
        model.addAttribute("list", membershipRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/membership";
    }

    @RequestMapping("/acr")
    public String acr(Model model) {
        model.addAttribute("list", acrRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/acr";
    }

    @RequestMapping("/retirementpension")
    public String retirementpension(Model model) {
        model.addAttribute("list", retirementPensionRepository.findAllByOrderByIdDesc());
        return "pims/report/basic/retirementpension";
    }

    @RequestMapping("/lprbyyear")
    public String lprByYear(Model model) {
        model.addAttribute("list", plrService.plrByYearList());
        return "pims/report/basic/plr_By_year";
    }

    @RequestMapping("/lastpromotion")
    public String lastpromotion(Model model) {
        model.addAttribute("list", promotionsService.lastPromotions());
        return "pims/report/basic/lastpromotionsr";
    }

}
