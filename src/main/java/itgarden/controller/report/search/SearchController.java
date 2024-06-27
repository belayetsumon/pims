/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.report.search;

import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.BloodGroup;
import itgarden.model.enumvalue.District;
import itgarden.model.enumvalue.EmployeeStatus;
import itgarden.model.enumvalue.EthnicIdentity;
import itgarden.model.enumvalue.Gender;
import itgarden.model.enumvalue.MaritalStatus;
import itgarden.model.enumvalue.Religion;
import itgarden.model.lookup.Department;
import itgarden.model.lookup.SubDepartment;
import itgarden.report.services.*;
import itgarden.repository.BatchRepository;
import itgarden.repository.CadreRepository;
import itgarden.repository.DepartmentRepository;
import itgarden.repository.GeneralInformationRepository;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingOrganizationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PresentPostingLocationRepository;
import itgarden.repository.SubDepartmentRepository;
import itgarden.repository.UsersRepository;
import itgarden.service.GeneralInformationService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/missearch")
public class SearchController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubDepartmentRepository subDepartmentRepository;

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
    GeneralInformationService generalInformationService;

    @Autowired
    PlrService plrService;

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model) {

        model.addAttribute("department", departmentRepository.findAll());

        model.addAttribute("subDepartment", subDepartmentRepository.findAll());

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

        model.addAttribute("year", plrService.YearList());

        return "pims/report/search/generalinformation_search_form";
    }

    @RequestMapping(value = {"/ginforlist"})
    public String ginforlist(Model model,
            @RequestParam(name = "governmentId", required = false) String governmentId,
            @RequestParam(name = "department", required = false) Department department,
            @RequestParam(name = "subDepartment", required = false) SubDepartment subDepartment,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "mobile", required = false) String mobile,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "nameBangla", required = false) String nameBangla,
            //            @RequestParam(name = "fathersName", required = false) String fathersName,
            //            @RequestParam(name = "fathersNameBangla", required = false) String fathersNameBangla,
            //            @RequestParam(name = "mothersName", required = false) String mothersName,
            //            @RequestParam(name = "mothersNameBangla", required = false) String mothersNameBangla,
            @RequestParam(name = "homeDistrict", required = false) District homeDistrict,
            @RequestParam(name = "dateofBirth", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dateofBirth,
            //            @RequestParam(name = "birthCountry", required = false) BirthCountry birthCountry,
            @RequestParam(name = "birthCertificateNumber", required = false) String birthCertificateNumber,
            @RequestParam(name = "gender", required = false) Gender gender,
            @RequestParam(name = "maritalStatus", required = false) MaritalStatus maritalStatus,
            @RequestParam(name = "religion", required = false) Religion religion,
            @RequestParam(name = "ethnicIdentity", required = false) EthnicIdentity ethnicIdentity,
            //            @RequestParam(name = "nationality", required = false) String nationality,
            @RequestParam(name = "bloodGroup", required = false) BloodGroup bloodGroup,
            //            @RequestParam(name = "drivingLicence", required = false) String drivingLicence,
            //            @RequestParam(name = "passportNo", required = false) String passportNo,
            @RequestParam(name = "nid", required = false) String nid,
            //            @RequestParam(name = "tin", required = false) String tin,
            @RequestParam(name = "lpryear", required = false) int lpryear,
            //            @RequestParam(name = "lPRStartDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date lPRStartDate, // LPR Date
            //            @RequestParam(name = "lPREndDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date lPREndDate,
            @RequestParam(name = "employeeStatus", required = false) EmployeeStatus employeeStatus // Employee Status: HOME DEPUTATION

    ) {
        model.addAttribute("list", generalInformationService.gInfoSearchList(governmentId, department, subDepartment, email, mobile, name, nameBangla, homeDistrict, dateofBirth, birthCertificateNumber, gender, maritalStatus, religion, ethnicIdentity, bloodGroup, nid, lpryear, employeeStatus));

        return "pims/report/search/generalinformation_list";
    }

}
