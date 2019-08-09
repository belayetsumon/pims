/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository;

import itgarden.model.GeneralInformation;
import itgarden.model.PresentJob;
import itgarden.model.Users;
import itgarden.model.enumvalue.Status;
import itgarden.model.lookup.Department;
import itgarden.model.lookup.Role;
import itgarden.model.lookup.SubDepartment;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Md Belayet Hossin
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByGovernmentId(String governmentId);

    Users findByGovernmentIdAndStatus(String governmentId, Status status);

    Users findByEmail(String email);
    
    Users findByMobile(String mobile);

    @Modifying
    @Transactional
    @Query("UPDATE Users  SET password=:password WHERE governmentId= :governmentId ")
    public void changePassword(@Param("governmentId") String governmentId, @Param("password") String password);

   

    List<Users> findByStatus(Status status);

    List<Users> findByStatusAndGeneralInformationIsNullOrderByIdDesc(Status status);

    List<Users> findByGeneralInformationIsNotNullOrderByIdDesc();

    List<Users> findByProfileImageIsNotNullOrderByIdDesc();

    List<Users> findByAdditionalQualificationIsNotNullOrderByIdDesc();

    List<Users> findByAddressInformationIsNotNullOrderByIdDesc();

    List<Users> findByChildrenInformationIsNotNullOrderByIdDesc();

    List<Users> findByDisciplinaryActionDetailsIsNotNullOrderByIdDesc();

    List<Users> findByEducationalInformationIsNotNullOrderByIdDesc();

    List<Users> findByFirstJoiningInformationIsNotNullOrderByIdDesc();

    List<Users> findByForeignTrainingInformationIsNotNullOrderByIdDesc();

    List<Users> findByForeignTravelIsNotNullOrderByIdDesc();

    List<Users> findByHonorsandawardIsNotNullOrderByIdDesc();

    List<Users> findByInServiceTrainingInformationIsNotNullOrderByIdDesc();

    List<Users> findByJobEntryProcessIsNotNullOrderByIdDesc();

    List<Users> findByLanguageinfoIsNotNullOrderByIdDesc();

    List<Users> findByLeaveinfoIsNotNullOrderByIdDesc();

    List<Users> findByMagisterialPowerIsNotNullOrderByIdDesc();

    List<Users> findByMembershipIsNotNullOrderByIdDesc();

    List<Users> findByOtherServiceInformationIsNotNullOrderByIdDesc();

    List<Users> findByPostingAbroadInformationIsNotNullOrderByIdDesc();

    List<Users> findByPostingRecordInformationIsNotNullOrderByIdDesc();

    List<Users> findByPresentJobIsNotNullOrderByIdDesc();

    List<Users> findByPromotionsInformationIsNotNullOrderByIdDesc();

    List<Users> findByPublicationInformationIsNotNullOrderByIdDesc();

    List<Users> findByRetirementPensionIsNotNullOrderByIdDesc();

    List<Users> findBySelectionGradeIsNotNullOrderByIdDesc();

    List<Users> findBySpousNameIsNotNullOrderByIdDesc();
    
    List<Users> findByAcrIsNotNullOrderByIdDesc();

    // directory 
    List<Users> findByGeneralInformationBloodGroupOrPresentJobPresentPostingRankOrPresentJobPresentPostingLocationOrPresentJobPostingDesignation(GeneralInformation bloodGroup, PresentJob presentPostingRank, PresentJob presentPostingLocation, PresentJob postingDesignation);

    
    /// null cheke
    
    
    List<Users> findByGeneralInformationIsNullOrderByIdDesc();

    List<Users> findByProfileImageIsNullOrderByIdDesc();

    List<Users> findByAdditionalQualificationIsNullOrderByIdDesc();

    List<Users> findByAddressInformationIsNullOrderByIdDesc();

    List<Users> findByChildrenInformationIsNullOrderByIdDesc();

    List<Users> findByDisciplinaryActionDetailsIsNullOrderByIdDesc();

    List<Users> findByEducationalInformationIsNullOrderByIdDesc();

    List<Users> findByFirstJoiningInformationIsNullOrderByIdDesc();

    List<Users> findByForeignTrainingInformationIsNullOrderByIdDesc();

    List<Users> findByForeignTravelIsNullOrderByIdDesc();

    List<Users> findByHonorsandawardIsNullOrderByIdDesc();

    List<Users> findByInServiceTrainingInformationIsNullOrderByIdDesc();

    List<Users> findByJobEntryProcessIsNullOrderByIdDesc();

    List<Users> findByLanguageinfoIsNullOrderByIdDesc();

    List<Users> findByLeaveinfoIsNullOrderByIdDesc();

    List<Users> findByMagisterialPowerIsNullOrderByIdDesc();

    List<Users> findByMembershipIsNullOrderByIdDesc();

    List<Users> findByOtherServiceInformationIsNullOrderByIdDesc();

    List<Users> findByPostingAbroadInformationIsNullOrderByIdDesc();

    List<Users> findByPostingRecordInformationIsNullOrderByIdDesc();

    List<Users> findByPresentJobIsNullOrderByIdDesc();

    List<Users> findByPromotionsInformationIsNullOrderByIdDesc();

    List<Users> findByPublicationInformationIsNullOrderByIdDesc();

    List<Users> findByRetirementPensionIsNullOrderByIdDesc();

    List<Users> findBySelectionGradeIsNullOrderByIdDesc();

    List<Users> findBySpousNameIsNullOrderByIdDesc();
    
     List<Users> findByAcrIsNullOrderByIdDesc();
}
