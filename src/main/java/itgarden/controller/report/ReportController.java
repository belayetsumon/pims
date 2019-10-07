/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.report;

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
@RequestMapping("/report")
@PreAuthorize("hasAuthority('report')")
public class ReportController {
    
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("userlist", usersRepository.findAll());
        
        // Not Null Check
        
        
        model.addAttribute("profile_image", usersRepository.findByProfileImageIsNotNullOrderByIdDesc().size());
        model.addAttribute("address", usersRepository.findByAddressInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("spouse", usersRepository.findBySpousNameIsNotNullOrderByIdDesc().size());
        model.addAttribute("children", usersRepository.findByChildrenInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("educational", usersRepository.findByEducationalInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("additionalQualifications", usersRepository.findByAdditionalQualificationIsNotNullOrderByIdDesc().size());
        model.addAttribute("language", usersRepository.findByLanguageinfoIsNotNullOrderByIdDesc().size());
        model.addAttribute("job_entry_process", usersRepository.findByJobEntryProcessIsNotNullOrderByIdDesc().size());
        model.addAttribute("first_job", usersRepository.findByFirstJoiningInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("present_job", usersRepository.findByPresentJobIsNotNullOrderByIdDesc().size());
        model.addAttribute("posting_record_information", usersRepository.findByPostingRecordInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("promotions_information", usersRepository.findByPromotionsInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("magistrial_power", usersRepository.findByMagisterialPowerIsNotNullOrderByIdDesc().size());
        model.addAttribute("selection_grade", usersRepository.findBySelectionGradeIsNotNullOrderByIdDesc().size());
        model.addAttribute("posting_abroad", usersRepository.findByPostingAbroadInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("foreign_training_information", usersRepository.findByForeignTrainingInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("in_service_training", usersRepository.findByInServiceTrainingInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("other_service", usersRepository.findByOtherServiceInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("honours_award", usersRepository.findByHonorsandawardIsNotNullOrderByIdDesc().size());
        model.addAttribute("disciplinary_action", usersRepository.findByDisciplinaryActionDetailsIsNotNullOrderByIdDesc().size());
        model.addAttribute("leave", usersRepository.findByLeaveinfoIsNotNullOrderByIdDesc().size());
        model.addAttribute("publication", usersRepository.findByPublicationInformationIsNotNullOrderByIdDesc().size());
        model.addAttribute("professional_Organization_membership", usersRepository.findByMembershipIsNotNullOrderByIdDesc().size());
        model.addAttribute("retirement_pension", usersRepository.findByRetirementPensionIsNotNullOrderByIdDesc().size());
        model.addAttribute("acr", usersRepository.findByAcrIsNotNullOrderByIdDesc().size());
        
        

        // Null check
        
        model.addAttribute("profile_null", usersRepository.findByProfileImageIsNullOrderByIdDesc().size());
        model.addAttribute("address_null", usersRepository.findByAddressInformationIsNullOrderByIdDesc().size());
        model.addAttribute("spouse_null", usersRepository.findBySpousNameIsNullOrderByIdDesc().size());
        model.addAttribute("children_null", usersRepository.findByChildrenInformationIsNullOrderByIdDesc().size());
        model.addAttribute("educational_null", usersRepository.findByEducationalInformationIsNullOrderByIdDesc().size());
        model.addAttribute("additionalQualifications_null", usersRepository.findByAdditionalQualificationIsNullOrderByIdDesc().size());
        model.addAttribute("language_null", usersRepository.findByLanguageinfoIsNullOrderByIdDesc().size());
        model.addAttribute("job_entry_process_null", usersRepository.findByJobEntryProcessIsNullOrderByIdDesc().size());
        model.addAttribute("first_job_null", usersRepository.findByFirstJoiningInformationIsNullOrderByIdDesc().size());
        model.addAttribute("present_job_null", usersRepository.findByPresentJobIsNullOrderByIdDesc().size());
        model.addAttribute("posting_record_information_null", usersRepository.findByPostingRecordInformationIsNullOrderByIdDesc().size());
        model.addAttribute("promotions_information_null", usersRepository.findByPromotionsInformationIsNullOrderByIdDesc().size());
        model.addAttribute("magistrial_power_null", usersRepository.findByMagisterialPowerIsNullOrderByIdDesc().size());
        model.addAttribute("selection_grade_null", usersRepository.findBySelectionGradeIsNullOrderByIdDesc().size());
        model.addAttribute("posting_abroad_null", usersRepository.findByPostingAbroadInformationIsNullOrderByIdDesc().size());
        model.addAttribute("foreign_training_information_null", usersRepository.findByForeignTrainingInformationIsNullOrderByIdDesc().size());
        model.addAttribute("in_service_training_null", usersRepository.findByInServiceTrainingInformationIsNullOrderByIdDesc().size());
        model.addAttribute("other_service_null", usersRepository.findByOtherServiceInformationIsNullOrderByIdDesc().size());
        model.addAttribute("honours_award_null", usersRepository.findByHonorsandawardIsNullOrderByIdDesc().size());
        model.addAttribute("disciplinary_action_null", usersRepository.findByDisciplinaryActionDetailsIsNullOrderByIdDesc().size());
        model.addAttribute("leave_null", usersRepository.findByLeaveinfoIsNullOrderByIdDesc().size());
        model.addAttribute("publication_null", usersRepository.findByPublicationInformationIsNullOrderByIdDesc().size());
        model.addAttribute("professional_Organization_membership_null", usersRepository.findByMembershipIsNullOrderByIdDesc().size());
        model.addAttribute("retirement_pension_null", usersRepository.findByRetirementPensionIsNullOrderByIdDesc().size());
        model.addAttribute("acr_null", usersRepository.findByAcrIsNullOrderByIdDesc().size());

        return "pims/report/index";
    }

}
