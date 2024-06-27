/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package itgarden.controller.report;

import itgarden.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/emptyreport")
@PreAuthorize("hasAuthority('basicreport')")
public class NullReportListController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }

    @RequestMapping("/profileImage")
    public String generalinformation(Model model) {
        model.addAttribute("list", usersRepository.findByProfileImageIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/addressinformation")
    public String addressinformation(Model model) {
        model.addAttribute("list", usersRepository.findByAddressInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/spouse")
    public String spouse(Model model) {
        model.addAttribute("list", usersRepository.findBySpousNameIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/childreninformation")
    public String childreninformation(Model model) {
        model.addAttribute("list", usersRepository.findByChildrenInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/educationalInformation")
    public String educationalInformation(Model model) {
        model.addAttribute("list", usersRepository.findByEducationalInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/additionalqualification")
    public String additionalqualification(Model model) {
        model.addAttribute("list", usersRepository.findByAdditionalQualificationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/language")
    public String language(Model model) {
        model.addAttribute("list", usersRepository.findByLanguageinfoIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/jobentryprocess")
    public String jobentryprocess(Model model) {
        model.addAttribute("list", usersRepository.findByJobEntryProcessIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/firstjoininginformation")
    public String firstjoininginformation(Model model) {
        model.addAttribute("list", usersRepository.findByFirstJoiningInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/presentjob")
    public String presentjob(Model model) {
        model.addAttribute("list", usersRepository.findByPresentJobIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/postingrecordinformation")
    public String postingrecordinformation(Model model) {
        model.addAttribute("list", usersRepository.findByPostingRecordInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/promotionsinformation")
    public String promotionsinformation(Model model) {
        model.addAttribute("list", usersRepository.findByPromotionsInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/magisterialpower")
    public String magisterialpower(Model model) {
        model.addAttribute("list", usersRepository.findByMagisterialPowerIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/selectiongrade")
    public String selectiongrade(Model model) {
        model.addAttribute("list", usersRepository.findBySelectionGradeIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/postingabroadinformation")
    public String postingabroadinformation(Model model) {
        model.addAttribute("list", usersRepository.findByPostingAbroadInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/foreigntraininginformation")
    public String foreigntraininginformation(Model model) {
        model.addAttribute("list", usersRepository.findByForeignTrainingInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/inservicetraininginformation")
    public String inservicetraininginformation(Model model) {
        model.addAttribute("list", usersRepository.findByInServiceTrainingInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/otherserviceinformation")
    public String otherserviceinformation(Model model) {
        model.addAttribute("list", usersRepository.findByOtherServiceInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/honorsandawardinformation")
    public String honorsandawardinformation(Model model) {
        model.addAttribute("list", usersRepository.findByHonorsandawardIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/disciplinaryaction")
    public String disciplinaryaction(Model model) {
        model.addAttribute("list", usersRepository.findByDisciplinaryActionDetailsIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/leaveinfo")
    public String leaveinfo(Model model) {
        model.addAttribute("list", usersRepository.findByLeaveinfoIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/publication")
    public String publication(Model model) {
        model.addAttribute("list", usersRepository.findByPublicationInformationIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/membership")
    public String membership(Model model) {
        model.addAttribute("list", usersRepository.findByMembershipIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/acr")
    public String acr(Model model) {
        model.addAttribute("list", usersRepository.findByAcrIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

    @RequestMapping("/retirementpension")
    public String retirementpension(Model model) {
        model.addAttribute("list", usersRepository.findByRetirementPensionIsNullOrderByIdDesc());
        return "pims/report/basic/empty_report";
    }

}
