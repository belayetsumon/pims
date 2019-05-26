/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.config;
import itgarden.model.Users;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Md Belayet Hossin
 */
@Configuration
public class Organizationinfo extends WebMvcConfigurerAdapter {

    @Autowired
    UsersRepository usersRepository;

    @Bean(name = "logedUserName")
    public String logedUserName() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Users users = usersRepository.findByGovernmentId(auth.getName());
            return users.getName();
        } catch (Exception e) {

            return null;
        }
    }
}
