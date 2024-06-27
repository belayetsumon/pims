/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springboot/CfgProperties.java to edit this template
 */
package itgarden.config;

import itgarden.componant.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.config.annotation.*;



/**
 *
 * @author Admin
 */

@Component
public class HandlerInterceptorConfig implements WebMvcConfigurer{

    @Autowired
    ProfileImageValidationComponent profileImageValidationComponent;
    
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(profileImageValidationComponent).addPathPatterns("/dashboards/index");
    }
    
 
}
