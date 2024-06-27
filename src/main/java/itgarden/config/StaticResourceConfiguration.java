/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.config;
import itgarden.componant.*;
import itgarden.service.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 *
 * @author Md Belayet Hossin
 */
@Configuration
public class StaticResourceConfiguration implements WebMvcConfigurer {

    @Autowired 
    StorageProperties properties;
    
     @Autowired
    ProfileImageValidationComponent profileImageValidationComponent;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations(properties.url());
    }
    
    
 
    
 
}
