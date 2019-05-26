/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.Batch;
import itgarden.model.lookup.Department;
import itgarden.repository.BatchRepository;
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
  @RequestMapping("/batch")
public class BatchController {
    
   @Autowired
    BatchRepository batchRepository;
    
    @RequestMapping("/index")
    public String index(Model model, Batch batch) {
  model.addAttribute("list", batchRepository.findAll());
        return "pims/lookup/batch";
    }
    
     @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Batch batch) {
        model.addAttribute("batch", batchRepository.findById(id));
        model.addAttribute("list", batchRepository.findAll());
        return "pims/lookup/batch";
    }

    @RequestMapping("/save")
    public String save(Model model,  @Valid Batch batch, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", batchRepository.findAll());
            return "pims/lookup/department";
        }
        batchRepository.save(batch);
        return "redirect:/batch/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Batch batch) {
        batchRepository.deleteById(id);
        return "redirect:/batch/index";
    }

}
