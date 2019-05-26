/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.Department;
import itgarden.repository.DepartmentRepository;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/index")
    public String index(Model model, Department department) {
        model.addAttribute("list", departmentRepository.findAll());
        return "pims/lookup/department";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Department department) {
        model.addAttribute("department", departmentRepository.findById(id));
        model.addAttribute("list", departmentRepository.findAll());
        return "pims/lookup/department";
    }

    @RequestMapping("/save")
    public String save(Model model,  @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", departmentRepository.findAll());
            return "pims/lookup/department";
        }
        departmentRepository.save(department);
        return "redirect:/department/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Department department) {
        departmentRepository.deleteById(id);
        return "redirect:/department/index";
    }

}
