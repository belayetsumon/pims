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

    @Modifying
    @Transactional
    @Query("UPDATE Users  SET name=:name,email=:email,"
            + "mobile=:mobile,"
            + "department=:department,subDepartment=:subDepartment,"
            + " role=:role ,"
            + " status=:status,"
            + "remarks=:remarks WHERE governmentId= :governmentId ")

    public void updateUsers(@Param("governmentId") String governmentId,
            @Param("name") String name,
            @Param("email") String email,
            @Param("mobile") String mobile,
            @Param("department") Department department,
            @Param("subDepartment") SubDepartment subDepartment,
            @Param("role") Set<Role> role,
            @Param("status") Status status,
            @Param("remarks") String remarks
    );

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

    // directory 
    List<Users> findByGeneralInformationBloodGroupOrPresentJobPresentPostingRankOrPresentJobPresentPostingLocationOrPresentJobPostingDesignation(GeneralInformation bloodGroup, PresentJob presentPostingRank, PresentJob presentPostingLocation, PresentJob postingDesignation);

}
