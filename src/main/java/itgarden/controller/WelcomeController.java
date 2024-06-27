/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.service.LoggedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller

public class WelcomeController {

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/")
    public String index(Model model) {

//        model.addAttribute("username", loggedUserService.activeUserName());
        return "welcome";
    }

}
