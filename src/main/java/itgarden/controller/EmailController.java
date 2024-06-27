/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.Users;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("attribute", "value");
        return "pims/email/index";
    }

    @RequestMapping("/groupemail")
    public String groupemail(Model model) {
        model.addAttribute("attribute", "value");
        return "pims/email/group_email";
    }

    @RequestMapping("/singleemail/{id}")
    public String singleemail(Model model, @PathVariable Long id) {

        Users users = usersRepository.getOne(id);

        if (users.getEmail() == null) {

            model.addAttribute("toEmailNull", "Email is not exits.");

        } else {
            model.addAttribute("toEmail", users.getEmail());
        }

        return "pims/email/single_email";
    }

    @RequestMapping("/singleemailsend")
    public String singleemailsend(Model model,
            @RequestParam(name = "from", required = false) String from,
            @RequestParam(name = "to", required = false) String to,
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "message", required = false) String message
    ) {

        model.addAttribute("attribute", "value");
        
        return "pims/email/single_email_success ";
    }

}
