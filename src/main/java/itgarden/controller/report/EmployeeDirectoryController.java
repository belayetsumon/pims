/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.report;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/employeedirectory")

public class EmployeeDirectoryController {

    @RequestMapping("/index")

    public String index(Model model) {

        model.addAttribute("attribute", "value");
        //return "pims/report/index";
        return "pims/report/employeedirectory/employeedirectory";
    }

}
