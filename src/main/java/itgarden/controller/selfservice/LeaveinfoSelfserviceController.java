/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.Leaveinfo;
import itgarden.model.Users;
import itgarden.model.enumvalue.LeaveType;
import itgarden.model.enumvalue.Status;
import itgarden.repository.LeaveinfoRepository;
import itgarden.service.LoggedUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/selfservice_leaveinfo")
@PreAuthorize("hasAuthority('selfservice_leaveinfo')")
public class LeaveinfoSelfserviceController {

    @Autowired
    LeaveinfoRepository leaveinfoRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, Leaveinfo leaveinfo) {

        Users users = new Users();
        users.setId(e_id);
        leaveinfo.setGovernmentId(users);
        model.addAttribute("list", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leavetypes", LeaveType.values());
        model.addAttribute("status", Status.values());
        return "pims/selfservice/leaveinfo";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Leaveinfo leaveinfo) {
        model.addAttribute("leaveinfo", leaveinfoRepository.getOne(id));
        Users users = new Users();
        users.setId(id);
        leaveinfo.setGovernmentId(users);
        model.addAttribute("list", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
        model.addAttribute("leavetypes", LeaveType.values());
        model.addAttribute("status", Status.values());
        return "pims/selfservice/leaveinfo";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid Leaveinfo leaveinfo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            leaveinfo.setGovernmentId(users);
            model.addAttribute("list", leaveinfoRepository.findByGovernmentIdOrderByIdDesc(users));
            model.addAttribute("leavetypes", LeaveType.values());
            model.addAttribute("status", Status.values());
            return "pims/selfservice/leaveinfo";
        }
        leaveinfo.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        leaveinfo.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        leaveinfoRepository.save(leaveinfo);
        return "redirect:/selfservice_leaveinfo/index/{e_id}";

    }

    @GetMapping(value = "/delete/{id}")

    public String delete(@PathVariable Long id, Leaveinfo leaveinfo, RedirectAttributes redirectAttrs) {

        leaveinfo = leaveinfoRepository.getOne(id);
        redirectAttrs.addAttribute("e_id", leaveinfo.getGovernmentId());
        leaveinfoRepository.deleteById(id);
        return "redirect:/selfservice_leaveinfo/index/{e_id}";

    }

}
