/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.componant.UserValidator;
import itgarden.model.Users;
import itgarden.model.enumvalue.Status;
import itgarden.model.lookup.Role;
import itgarden.repository.DepartmentRepository;
import itgarden.repository.RoleRepository;
import itgarden.repository.SubDepartmentRepository;
import itgarden.repository.UsersRepository;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubDepartmentRepository subDepartmentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserValidator userValidator;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("alluser", usersRepository.findAll());
        return "pims/users/allusers";
    }

    @RequestMapping("/userbystatus")
    public String userByStatus(Model model, @RequestParam(value = "status", required = false) Status status) {

        model.addAttribute("status", Status.values());

        model.addAttribute("alluser", usersRepository.findByStatus(status));

        return "pims/users/allusers_by_status";

    }

    @RequestMapping("/view/{uid}")
    public String view(Model model, @PathVariable Long uid) {
        model.addAttribute("users", usersRepository.getOne(uid));
        return "pims/users/view";
    }

    @RequestMapping("/registrations")
    public String registrations(Model model, Users users) {
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("subDepartment", subDepartmentRepository.findAll());
        model.addAttribute("role", roleRepository.findAll());
        model.addAttribute("status", Status.values());
        return "pims/users/registrations";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Users users) {
        model.addAttribute("users", usersRepository.getOne(id));
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("subDepartment", subDepartmentRepository.findAll());
        model.addAttribute("role", roleRepository.findAll());
        model.addAttribute("status", Status.values());
        return "pims/users/registrations";
    }

//    @RequestMapping("/Esave")
//    //@Transactional
//    public String editSave(Model model, @Valid Users users, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("department", departmentRepository.findAll());
//            model.addAttribute("subDepartment", subDepartmentRepository.findAll());
//            model.addAttribute("role", roleRepository.findAll());
//            model.addAttribute("status", Status.values());
//            return "pims/users/registrations_edit";
//        }
//
//        // users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//        try {
//            
//          
//            users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//  
//            usersRepository.updateUsers(governmentId, name, email, mobile, department, subDepartment, role, Status.Others, remarks);save(users);
//            return "redirect:/users/index";
//            
//        } catch (Exception e) {
//            model.addAttribute("department", departmentRepository.findAll());
//            model.addAttribute("subDepartment", subDepartmentRepository.findAll());
//            model.addAttribute("role", roleRepository.findAll());
//            model.addAttribute("status", Status.values());
//            redirectAttributes.addFlashAttribute("message", e);
//            model.addAttribute("message", e);
//            return "pims/users/registrations_edit";
//        }
//    }
//    
//    
//    
    @RequestMapping("/save")
    //@Transactional
    public String save(Model model, @RequestParam(value = "password2", required = false) String password2, @Valid Users users, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("department", departmentRepository.findAll());
            model.addAttribute("subDepartment", subDepartmentRepository.findAll());
            model.addAttribute("role", roleRepository.findAll());
            model.addAttribute("status", Status.values());
            return "pims/users/registrations";
        }

        // users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        try {

            if (users.getPassword().isEmpty() && password2 != null && users.getId() != null) {

                users.setPassword(password2);
            } else {

                users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
            }

            usersRepository.save(users);
            return "redirect:/users/index";

        } catch (Exception e) {
            model.addAttribute("department", departmentRepository.findAll());
            model.addAttribute("subDepartment", subDepartmentRepository.findAll());
            model.addAttribute("role", roleRepository.findAll());
            model.addAttribute("status", Status.values());
            redirectAttributes.addFlashAttribute("message", e);
            model.addAttribute("message", e);
            return "pims/users/registrations";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Users users) {
        usersRepository.deleteById(id);
        return "redirect:/users/index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("attribute", "value");

        model.addAttribute("logout", " You are successfully logout");
        return "pims/users/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/users/login";
    }

    @RequestMapping("/detailsinfo/{id}")
    public String details(Model model, @PathVariable Long id) {
        model.addAttribute("employee", usersRepository.getOne(id));
        return "pims/details/details";
    }

    @RequestMapping("/front-registrations")
    public String uregistrations(Model model, Users users) {
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("subDepartment", subDepartmentRepository.findAll());
        model.addAttribute("role", roleRepository.findAll());
        return "pims/users/front_registrations";
    }

    @RequestMapping("/front-registrations-save")
    public String usave(Model model, @Valid Users users, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        userValidator.validate(users, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("department", departmentRepository.findAll());
            model.addAttribute("subDepartment", subDepartmentRepository.findAll());
            model.addAttribute("role", roleRepository.findAll());
            return "pims/users/front_registrations";
        }

        Set<Role> role = roleRepository.findBySlug("user");
        users.setRole(role);
        users.setStatus(Status.Pending);
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        redirectAttributes.addFlashAttribute("success", " Congratulations you have successfully registered. please contact with system adminstrator for active your ID .");
        return "redirect:/users/login";
    }
}
