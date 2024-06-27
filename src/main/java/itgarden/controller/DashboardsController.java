/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.repository.DepartmentRepository;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/dashboards")
@PreAuthorize("hasAuthority('dashboards')")
public class DashboardsController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PostingRankRepository postingRankRepository;

    @Autowired
    private UsersRepository usersRepository;

    String governmentId = "123456";

    // @PreAuthorize("hasRole('Admin')")
    @RequestMapping("/index")
   //@Secured("user")
   // @PreAuthorize("user")
    public String index(Model model) {
        model.addAttribute("attribute", "value");
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("designation", postingDesignationRepository.findAll(Sort.by(Sort.Direction.ASC, "orderId")));
        model.addAttribute("postingrank", postingRankRepository.findAll());
        model.addAttribute("user", usersRepository.findByGovernmentId(governmentId));
        return "dashboards/index";
    }

    @RequestMapping("/")
   // @Secured("user")
    public String index2(Model model) {
        model.addAttribute("attribute", "value");
        return "dashboards/index";
    }
}
