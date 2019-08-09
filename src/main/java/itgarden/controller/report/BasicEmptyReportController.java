/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.report;

import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/basicempty")
public class BasicEmptyReportController {
    
    @Autowired
    UsersRepository usersRepository;
    
   @RequestMapping("/generalinformation")
    public String generalinformation(Model model) {
        model.addAttribute("list", usersRepository.findByGeneralInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/generalinformation";
    }
    
//    @RequestMapping("/generalinformation")
//    public String generalinformation(Model model) {
//        model.addAttribute("list", usersRepository.findByGeneralInformationIsNotNullOrderByIdDesc());
//        return "/pims/report/empty/generalinformation";
//    }

    @RequestMapping("/addressinformation")
    public String addressinformation(Model model) {
        model.addAttribute("list", usersRepository.findByAddressInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/addressinformation";
    }

    @RequestMapping("/spouse")
    public String spouse(Model model) {
         model.addAttribute("list", usersRepository.findBySpousNameIsNotNullOrderByIdDesc());
        return "/pims/report/empty/spouse";
    }

    @RequestMapping("/childreninformation")
    public String childreninformation(Model model) {
       model.addAttribute("list", usersRepository.findByChildrenInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/childreninformation";
    }

    @RequestMapping("/educationalInformation")
    public String educationalInformation(Model model) {
        model.addAttribute("list", usersRepository.findByEducationalInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/educationalInformation";
    }

    @RequestMapping("/additionalqualification")
    public String additionalqualification(Model model) {
        model.addAttribute("list", usersRepository.findByAdditionalQualificationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/additionalqualification";
    }

    @RequestMapping("/language")
    public String language(Model model) {
         model.addAttribute("list", usersRepository.findByLanguageinfoIsNotNullOrderByIdDesc());
        return "/pims/report/empty/language";
    }

    @RequestMapping("/jobentryprocess")
    public String jobentryprocess(Model model) {
         model.addAttribute("list", usersRepository.findByGeneralInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/jobentryprocess";
    }

    @RequestMapping("/firstjoininginformation")
    public String firstjoininginformation(Model model) {
        model.addAttribute("list", usersRepository.findByGeneralInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/firstjoininginformation";
    }

    @RequestMapping("/presentjob")
    public String presentjob(Model model) {
         model.addAttribute("list", usersRepository.findByPresentJobIsNotNullOrderByIdDesc());
        return "/pims/report/empty/presentjob";
    }

    @RequestMapping("/postingrecordinformation")
    public String postingrecordinformation(Model model) {
         model.addAttribute("list", usersRepository.findByPostingRecordInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/postingrecordinformation";
    }

    @RequestMapping("/promotionsinformation")
    public String promotionsinformation(Model model) {
      model.addAttribute("list", usersRepository.findByPromotionsInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/promotionsinformation";
    }

    @RequestMapping("/magisterialpower")
    public String magisterialpower(Model model) {
         model.addAttribute("list", usersRepository.findByMagisterialPowerIsNotNullOrderByIdDesc());
        return "/pims/report/empty/magisterialpower";
    }

    @RequestMapping("/selectiongrade")
    public String selectiongrade(Model model) {
        model.addAttribute("list", usersRepository.findBySelectionGradeIsNotNullOrderByIdDesc());
        return "/pims/report/empty/selectiongrade";
    }

    @RequestMapping("/postingabroadinformation")
    public String postingabroadinformation(Model model) {
       model.addAttribute("list", usersRepository.findByPostingAbroadInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/postingabroadinformation";
    }

    @RequestMapping("/foreigntraininginformation")
    public String foreigntraininginformation(Model model) {
        model.addAttribute("list", usersRepository.findByForeignTrainingInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/foreigntraininginformation";
    }

    @RequestMapping("/inservicetraininginformation")
    public String inservicetraininginformation(Model model) {
         model.addAttribute("list", usersRepository.findByGeneralInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/inservicetraininginformation";
    }

    @RequestMapping("/otherserviceinformation")
    public String otherserviceinformation(Model model) {
         model.addAttribute("list", usersRepository.findByOtherServiceInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/otherserviceinformation";
    }

    @RequestMapping("/honorsandawardinformation")
    public String honorsandawardinformation(Model model) {
        model.addAttribute("list", usersRepository.findByHonorsandawardIsNotNullOrderByIdDesc());
        return "/pims/report/empty/honorsandawardinformation";
    }

    @RequestMapping("/disciplinaryaction")
    public String disciplinaryaction(Model model) {
         model.addAttribute("list", usersRepository.findByDisciplinaryActionDetailsIsNotNullOrderByIdDesc());
        return "/pims/report/empty/disciplinaryaction";
    }

    @RequestMapping("/leaveinfo")
    public String leaveinfo(Model model) {
         model.addAttribute("list", usersRepository.findByLeaveinfoIsNotNullOrderByIdDesc());
        return "/pims/report/empty/leaveinfo";
    }

    @RequestMapping("/publication")
    public String publication(Model model) {
         model.addAttribute("list", usersRepository.findByPublicationInformationIsNotNullOrderByIdDesc());
        return "/pims/report/empty/publication";
    }

    @RequestMapping("/membership")
    public String membership(Model model) {
         model.addAttribute("list", usersRepository.findByMembershipIsNotNullOrderByIdDesc());
        return "/pims/report/empty/membership";
    }

    @RequestMapping("/retirementpension")
    public String retirementpension(Model model) {
         model.addAttribute("list", usersRepository.findByRetirementPensionIsNotNullOrderByIdDesc());
        return "/pims/report/empty/retirementpension";
    }

    
}
