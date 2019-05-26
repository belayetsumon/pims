/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.report;

import itgarden.repository.DepartmentRepository;
import itgarden.repository.SubDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/classified")
public class ClassifiedReportController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubDepartmentRepository subDepartmentRepository;

    @RequestMapping("/departmentindex")
    public String departmentindex(Model model) {

        model.addAttribute("department", departmentRepository.findAll());

        model.addAttribute("subdepartment", subDepartmentRepository.findAll());

        return "/pims/report/classified/department_index";
    }

    @RequestMapping("/department_report")
    public String department_report(Model model) {
        model.addAttribute("attribute", "value");
        return "/pims/report/classified/department_report";
    }

    @RequestMapping("/districtindex")
    public String districtindex(Model model) {

        return "/pims/report/classified/district_index";
    }

    @RequestMapping("/religionindex")
    public String religionindex(Model model) {

        return "/pims/report/classified/religion_index";
    }

    @RequestMapping("/designationindex")
    public String designationindex(Model model) {

        return "/pims/report/classified/designation_index";
    }

    @RequestMapping("/postindex")
    public String postindex(Model model) {

        return "/pims/report/classified/post_index";
    }

    @RequestMapping("/locationindex")
    public String locationindex(Model model) {

        return "/pims/report/classified/location_index";

    }

    @RequestMapping("/lprindex")
    public String lprindex(Model model) {

        return "/pims/report/classified/lpr_index";

    }
    
    @RequestMapping("/leaveindex")
    public String leaveindex(Model model) {

        return "/pims/report/classified/leave_index";

    }

}
