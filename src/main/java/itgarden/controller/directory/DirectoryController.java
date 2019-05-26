/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.directory;

import itgarden.model.GeneralInformation;
import itgarden.model.PresentJob;
import itgarden.model.enumvalue.BloodGroup;
import itgarden.repository.PostingDesignationRepository;
import itgarden.repository.PostingRankRepository;
import itgarden.repository.PresentPostingLocationRepository;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/directory")
public class DirectoryController {
    
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PostingDesignationRepository postingDesignationRepository;

    @Autowired
    PostingRankRepository PostingRankRepository;

    @Autowired
    PresentPostingLocationRepository presentPostingLocationRepository;
    
    

    @RequestMapping("/directory")
    public String index(Model model,
            
            @RequestParam(value = "bloodGroup", required = false) GeneralInformation bloodGroup,
            @RequestParam(value = "postingRank", required = false) PresentJob presentPostingRank,
            @RequestParam(value = "presentPostingLocation", required = false) PresentJob presentPostingLocation,
            @RequestParam(value = "postingDesignation", required = false) PresentJob postingDesignation
    ) {

        model.addAttribute("bloodgroup", BloodGroup.values());
        
        model.addAttribute("postingrank", PostingRankRepository.findAll());
        
        model.addAttribute("postingdesignation", postingDesignationRepository.findAll());
        
        model.addAttribute("presentpostinglocation", presentPostingLocationRepository.findAll());
        
        
         model.addAttribute("employee", usersRepository.findByGeneralInformationBloodGroupOrPresentJobPresentPostingRankOrPresentJobPresentPostingLocationOrPresentJobPostingDesignation(bloodGroup, presentPostingRank, presentPostingLocation, postingDesignation));

        return "directory/directory";
        
    }
    
    
    

}
