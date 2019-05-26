/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("attribute", "value");
        return "demo/index";
    }
    
    
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("attribute", "value");
        return "demo/add";
    }
    
    @RequestMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("attribute", "value");
        return "demo/edit";
    }
    
    @RequestMapping("/single_view")
    public String singleView(Model model) {
        model.addAttribute("attribute", "value");
        return "demo/single_view";
    }
    
    
    @RequestMapping("/blank_page")
    public String blankPage(Model model) {
        model.addAttribute("attribute", "value");
        return "demo/blank_page";
    }
}
