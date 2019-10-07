/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.Users;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("usersprofile")
@PreAuthorize("hasAuthority('usersprofile')")
public class UsersProfileController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")

    public String index(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Users users = usersRepository.findByGovernmentId(auth.getName());

       model.addAttribute("employee", usersRepository.getOne(users.getId()));

        return "pims/selfservice/index";
    }

}
