/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author User
 */

public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public String Notfound(Model model, HttpServletRequest request, Exception ex) {

        model.addAttribute("error", ex.toString());

        return "error/index";
    }
}
