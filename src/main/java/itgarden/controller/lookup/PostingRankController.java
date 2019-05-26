/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.PostingRank;
import itgarden.repository.PostingRankRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/postingrank")
public class PostingRankController {
    
    @Autowired
    PostingRankRepository postingRankRepository;
    
    @RequestMapping("/index")
    public String index(Model model, PostingRank postingRank) {
        model.addAttribute("list", postingRankRepository.findAll());
        return "pims/lookup/postingrank";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, PostingRank postingRank) {
        model.addAttribute("postingRank", postingRankRepository.findById(id));
        model.addAttribute("list", postingRankRepository.findAll());
        return "pims/lookup/postingrank";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid PostingRank postingRank, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", postingRankRepository.findAll());
            return "pims/lookup/postingrank";
        }
        postingRankRepository.save(postingRank);
        return "redirect:/postingrank/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, PostingRank postingRank) {
        postingRankRepository.deleteById(id);
        return "redirect:/postingrank/index";
    }

}
