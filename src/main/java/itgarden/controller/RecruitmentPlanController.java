/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.RecruitmentPlan;
import itgarden.repository.DepartmentRepository;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.RecruitmentPlanRepository;
import itgarden.repository.SubDepartmentRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/recruitmentplan")
@PreAuthorize("hasAuthority('recruitmentplan')")
public class RecruitmentPlanController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubDepartmentRepository subDepartmentRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    RecruitmentPlanRepository recruitmentPlanRepository;

    @RequestMapping("/index")
    public String index(Model model, RecruitmentPlan recruitmentPlan) {

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("department", departmentRepository.findAll());

        model.addAttribute("subDepartment", subDepartmentRepository.findAll());

        return "pims/recruitmentplan/recruitmentplan";
    }

    @RequestMapping("/list")
    public String list(Model model, RecruitmentPlan recruitmentPlan) {

        model.addAttribute("list", recruitmentPlanRepository.findAll());

        return "pims/recruitmentplan/recruitmentplan_list";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid RecruitmentPlan recruitmentPlan, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("designation", postingDesignationRepository.findAll());

            model.addAttribute("department", departmentRepository.findAll());

            model.addAttribute("subDepartment", subDepartmentRepository.findAll());

            return "pims/recruitmentplan/recruitmentplan";
        }
        recruitmentPlanRepository.save(recruitmentPlan);
        return "redirect:/recruitmentplan/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, RecruitmentPlan recruitmentPlan) {

        model.addAttribute("recruitmentPlan", recruitmentPlanRepository.getOne(id));

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("department", departmentRepository.findAll());

        model.addAttribute("subDepartment", subDepartmentRepository.findAll());

       return "pims/recruitmentplan/recruitmentplan";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, RecruitmentPlan recruitmentPlan, RedirectAttributes redirectAttrs) {
        recruitmentPlanRepository.deleteById(id);
     return "redirect:/recruitmentplan/list";
    }

}
