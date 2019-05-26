/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.selfservice;

import itgarden.model.Membership;
import itgarden.model.Users;
import itgarden.repository.MembershipRepository;
import itgarden.service.LoggedUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/selfservice_membership")
public class MembershipSelfserviceController {

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")
    public String index(Model model, @PathVariable Long e_id, Membership membership) {

        Users users = new Users();

        users.setId(e_id);

        membership.setGovernmentId(users);

        model.addAttribute("list", membershipRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/membership";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Membership membership) {
        model.addAttribute("membership", membershipRepository.getOne(id));
        Users users = new Users();

        users.setId(id);

        membership.setGovernmentId(users);

        model.addAttribute("list", membershipRepository.findByGovernmentIdOrderByIdDesc(users));

        return "pims/selfservice/membership";

    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid Membership membership, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();

            users.setId(e_id);

            membership.setGovernmentId(users);

            model.addAttribute("list", membershipRepository.findByGovernmentIdOrderByIdDesc(users));

            return "pims/selfservice/membership";

        }

        membership.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        membership.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        membershipRepository.save(membership);
        return "redirect:/selfservice_membership/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")

    public String delete(@PathVariable Long id, Membership membership, RedirectAttributes redirectAttrs) {

        membership = membershipRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", membership.getGovernmentId());

        membershipRepository.deleteById(id);

        return "redirect:/selfservice_membership/index/{e_id}";

    }

}
