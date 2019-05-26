/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.user;

import itgarden.model.Users;
import itgarden.repository.UsersRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/forgotpassword")
public class ForgotPasswordController {

//    @Autowired
//    private JavaMailSender sender;
    @Autowired
    UsersRepository usersRepository;

    @Autowired

    private JavaMailSender sender;

    @RequestMapping("/userforgotpassword")
    public String userforgotpassword(Model model) {
        model.addAttribute("attribute", "value");
        return "pims/users/forgotpassword";
    }

    @RequestMapping("/showemail")
    public String showemail(@RequestParam(required = false, name = "email") String email, Model model) throws MessagingException {

        Users user = usersRepository.findByEmail(email);

        if (user == null) {

            model.addAttribute("emailNotFound", "This email is not exist.");

            return "pims/users/forgotpassword";
        }

        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("belayetsumon@itgardenltd.com");
        helper.setText("How are you?");
        helper.setSubject("Hi from pims");
        sender.send(message);

        model.addAttribute("user", "Hello Mr " + user.getName() + "  Your ID : " + user.getGovernmentId() + " Your password has been sent successfully! Please check your email.");
        return "pims/users/showemail";
    }

//    @RequestMapping("/simpleemail")
//    @ResponseBody
//    String home() {
//        try {
//            sendEmail();
//            return "Email Sent!";
//        } catch (Exception ex) {
//            return "Error in sending email: " + ex;
//        }
//    }
//    private void sendEmail() throws Exception {
//        MimeMessage message = sender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//        helper.setTo("set-your-recipient-email-here@gmail.com");
//        helper.setText("How are you?");
//        helper.setSubject("Hi");
//        sender.send(message);
//
//    }
}
