/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/detailsinfo/{e_id}")
    public String details(Model model, @PathVariable Long e_id) {
        model.addAttribute("employee", usersRepository.getOne(e_id));
        return "pims/details/details";
    }

}
