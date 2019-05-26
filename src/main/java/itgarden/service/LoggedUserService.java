/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.service;

import itgarden.model.Users;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Md Belayet Hossin
 */
@Service
public class LoggedUserService {

    @Autowired
    UsersRepository usersRepository;

    public String activeUserName() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = usersRepository.findByGovernmentId(auth.getName());
        return users.getName();
    }
    
    public String activeUserNameAndGovernmentId() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = usersRepository.findByGovernmentId(auth.getName());
        
        String nameandid= users.getName()+"( Govt:ID "+users.getGovernmentId()+")";
        
        return nameandid;
    }

}
