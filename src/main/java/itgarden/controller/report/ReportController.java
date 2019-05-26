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
@RequestMapping("/report")
public class ReportController {
    
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("userlist", usersRepository.findAll());
        return "pims/report/index";
    }

}
