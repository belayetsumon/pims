/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Component.java to edit this template
 */
package itgarden.componant;

import javax.servlet.http.*;
import org.springframework.stereotype.*;

import org.springframework.web.servlet.*;

/**
 *
 * @author Admin
 */
@Component
public class ProfileImageValidationComponent implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        


  System.out.println("Hello BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBangladesh");

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Hello BBBBBBB   22222222222222222222");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
          System.out.println("Hello BBBBBBB   333333333333333333333333333");
    }




    
    
    
}
