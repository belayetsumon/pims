/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.controller;

import itgarden.model.testmodel;
import itgarden.repository.testmodelRepository;
import org.hibernate.cfg.annotations.reflection.XMLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/testmodel")
public class TestModelController {

    @Autowired
    testmodelRepository testmodelrepository;

    @RequestMapping("/index")
    public String index(Model model,@RequestParam(defaultValue = "0") int page) {
     //   model.addAttribute("data", testmodelrepository.findAll());
        
         Pageable pageable;
        pageable = new PageRequest(page, 15, Sort.Direction.DESC, "id");

        Page<testmodel> pages = testmodelrepository.findAll(pageable);

        //System.out.println("hello"+pages);
        model.addAttribute("list", pages);
        model.addAttribute("currentPage", page);

        /// Pagination Short ////
        // Loop Start value
        int startPage = 0;

        // Loop end  value
        int endPage = 0;

        if (pages.getTotalPages() <= 10) {
            // less than 10 total pages so show all
            startPage = 0;
            endPage = pages.getTotalPages();
        } else // more than 10 total pages so calculate start and end pages
        {
            if (page <= 6) {
                startPage = 0;
                endPage = 10;
            } else if (page + 4 >= pages.getTotalPages()) {
                startPage = pages.getTotalPages() - 9;
                endPage = pages.getTotalPages();
            } else {
                startPage = page - 5;
                endPage = page + 4;
            }
        }
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        
        
        return "pims/testmodel/testmodel";
    }

    @RequestMapping("/all")
    @ResponseBody
    public Page<testmodel> all(Model model) {
        Long id = null;
        Pageable pageable = new PageRequest(1, 20);

        Page<testmodel> data = testmodelrepository.findAll(pageable);
        return data;
    }

//    @RequestMapping("/pagging")
//    public String pagging(Model model, Pageable pageable) {
//        Long id = null;
//        pageable = new PageRequest(1, 20);
//
//        model.addAttribute("data", testmodelrepository.findAll(pageable));
//
//        //Page<testmodel> data = testmodelrepository.findAll(pageable);
//        return "pims/testmodel/pagging";
//    }
//    
   
    @RequestMapping("/pagging")
    public String pagging(Model model, @RequestParam(defaultValue = "0")int page) {

        model.addAttribute("data", testmodelrepository.findAll(new PageRequest(0, 50)));

        //Page<testmodel> data = testmodelrepository.findAll(pageable);
        
        return "pims/testmodel/pagging";
    }

}
