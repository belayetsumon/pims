/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.enumvalue.District;
import itgarden.model.lookup.Thana;
import itgarden.repository.ThanaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/thana")
//@PreAuthorize("hasAuthority('privilege')")
public class ThanaController {

    @Autowired
    ThanaRepository thanaRepository;

    @RequestMapping("/index")
    public String index(Model model, Thana thana) {

        model.addAttribute("districts", District.values());

        model.addAttribute("thanas", thanaRepository.findAll());

        return "pims/lookup/thana";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Thana thana) {
        model.addAttribute("thana", thanaRepository.findById(id));
        model.addAttribute("districts", District.values());
        model.addAttribute("thanas", thanaRepository.findAll());
        return "pims/lookup/thana";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Thana thana, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("districts", District.values());
            model.addAttribute("thanas", thanaRepository.findAll());
            return "pims/lookup/thana";
        }
        thanaRepository.save(thana);
        return "redirect:/thana/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Thana thana) {
        thanaRepository.deleteById(id);
        return "redirect:/thana/index";
    }

    @RequestMapping(value = "/bydistrict/{district}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Thana> bydistrict(@PathVariable District district, Thana thana) {

        List<Thana> thanalist = thanaRepository.findByDistrict(district);
        return thanalist;
    }

}
