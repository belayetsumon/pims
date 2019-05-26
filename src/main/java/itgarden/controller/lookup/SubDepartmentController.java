/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller.lookup;

import itgarden.model.lookup.Department;
import itgarden.model.lookup.SubDepartment;
import itgarden.repository.DepartmentRepository;
import itgarden.repository.SubDepartmentRepository;
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
@RequestMapping("/subdepartment")
public class SubDepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubDepartmentRepository subDepartmentRepository;

    @RequestMapping("/index")
    public String index(Model model, SubDepartment subDepartment) {

        model.addAttribute("list", subDepartmentRepository.findAll());

        model.addAttribute("department", departmentRepository.findAll());

        return "pims/lookup/subdepartment";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, SubDepartment subDepartment) {

        model.addAttribute("subDepartment", subDepartmentRepository.findById(id));

        model.addAttribute("list", subDepartmentRepository.findAll());

        model.addAttribute("department", departmentRepository.findAll());

       return "pims/lookup/subdepartment";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid SubDepartment subDepartment, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("list", subDepartmentRepository.findAll());

            model.addAttribute("department", departmentRepository.findAll());

            return "pims/lookup/department";
        }

        subDepartmentRepository.save(subDepartment);

        return "redirect:/subdepartment/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, SubDepartment subDepartment) {

        subDepartmentRepository.deleteById(id);

        return "redirect:/subdepartment/index";
    }

    
    @RequestMapping(value = "/bydepartment/{department}",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SubDepartment> byDepartment(@PathVariable Department department, SubDepartment subDepartment) {
       
        List<SubDepartment> subdepartmentlist = subDepartmentRepository.findByDepartment(department);

        return subdepartmentlist;

    }
    
    
    @RequestMapping(value = "/allsubdepertment", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SubDepartment> allsubdepartment( SubDepartment subDepartment) {
       
        List<SubDepartment> subdepartmentlist = subDepartmentRepository.findAll();

        return subdepartmentlist;

    }

}
