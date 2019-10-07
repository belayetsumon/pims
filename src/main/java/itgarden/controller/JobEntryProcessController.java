/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.JobEntryProcess;
import itgarden.model.Users;
import itgarden.model.enumvalue.Authority;
import itgarden.model.enumvalue.ExamType;
import itgarden.model.enumvalue.PostType;
import itgarden.model.enumvalue.Quota;
import itgarden.model.enumvalue.SelectionType;
import itgarden.model.enumvalue.Selectiongrade;
import itgarden.repository.BatchRepository;
import itgarden.repository.JobEntryProcessRepository;
import itgarden.repository.PostingDesignationRepository;
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
@RequestMapping("/jobentryprocess")
@PreAuthorize("hasAuthority('jobentryprocess')")
public class JobEntryProcessController {

    @Autowired
    JobEntryProcessRepository jobEntryProcessRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    BatchRepository batchRepository;
    
    @Autowired
    LoggedUserService loggedUserService;

    @RequestMapping("/index/{e_id}")

    public String index(Model model, @PathVariable Long e_id, JobEntryProcess jobEntryProcess) {

        Users users = new Users();

        users.setId(e_id);
        jobEntryProcess.setGovernmentId(users);
        model.addAttribute("list", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("authority", Authority.values());

        model.addAttribute("authority", Authority.values());

        model.addAttribute("examType", ExamType.values());

        model.addAttribute("grade", Selectiongrade.values());

        model.addAttribute("selectionType", SelectionType.values());

        model.addAttribute("quota", Quota.values());

        model.addAttribute("batch", batchRepository.findAll());

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postType", PostType.values());

        return "pims/jobentryprocess/jobentryprocess";
    }

    @RequestMapping("/edit/{id}")

    public String edit(Model model, @PathVariable Long id, JobEntryProcess jobEntryProcess) {

        model.addAttribute("jobEntryProcess", jobEntryProcessRepository.getOne(id));

        Users users = new Users();

        users.setId(id);

        jobEntryProcess.setGovernmentId(users);

        model.addAttribute("list", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));

        model.addAttribute("authority", Authority.values());

        model.addAttribute("authority", Authority.values());

        model.addAttribute("examType", ExamType.values());

        model.addAttribute("grade", Selectiongrade.values());

        model.addAttribute("selectionType", SelectionType.values());

        model.addAttribute("quota", Quota.values());

        model.addAttribute("batch", batchRepository.findAll());

        model.addAttribute("designation", postingDesignationRepository.findAll());

        model.addAttribute("postType", PostType.values());

        return "pims/jobentryprocess/jobentryprocess";
    }

    @RequestMapping("/save/{e_id}")
    public String save(Model model, @PathVariable Long e_id, @Valid JobEntryProcess jobEntryProcess, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Users users = new Users();
            users.setId(e_id);
            jobEntryProcess.setGovernmentId(users);

            model.addAttribute("list", jobEntryProcessRepository.findByGovernmentIdOrderByIdDesc(users));

            model.addAttribute("authority", Authority.values());

            model.addAttribute("authority", Authority.values());

            model.addAttribute("examType", ExamType.values());

            model.addAttribute("grade", Selectiongrade.values());

            model.addAttribute("selectionType", SelectionType.values());

            model.addAttribute("quota", Quota.values());

            model.addAttribute("batch", batchRepository.findAll());

            model.addAttribute("designation", postingDesignationRepository.findAll());

            model.addAttribute("postType", PostType.values());

            return "pims/jobentryprocess/jobentryprocess";

        }
        
        jobEntryProcess.setCreatedBy(loggedUserService.activeUserNameAndGovernmentId());
        jobEntryProcess.setUpdatedBy(loggedUserService.activeUserNameAndGovernmentId());
        
        jobEntryProcessRepository.save(jobEntryProcess);
        return "redirect:/jobentryprocess/index/{e_id}";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, JobEntryProcess jobEntryProcess, RedirectAttributes redirectAttrs) {

        jobEntryProcess = jobEntryProcessRepository.getOne(id);

        redirectAttrs.addAttribute("e_id", jobEntryProcess.getGovernmentId());

        jobEntryProcessRepository.deleteById(id);

        return "redirect:/jobentryprocess/index/{e_id}";
    }

}
