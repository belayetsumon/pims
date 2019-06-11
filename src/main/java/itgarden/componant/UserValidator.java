/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.componant;

import itgarden.model.Users;
import itgarden.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author User
 */
@Component
public class  UserValidator  implements  Validator {
    
    @Autowired
    UsersRepository usersRepository;

@Override
public boolean supports(Class<?> aClass) {
        return Users.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
       
        Users user = (Users) o;
        
        if (usersRepository.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.users.email");
        }
        
         if (usersRepository.findByGovernmentId(user.getGovernmentId()) != null) {
             
            errors.rejectValue("governmentId", "Duplicate.users.governmentId");
        }

         
          if (usersRepository.findByMobile(user.getMobile()) != null) {
             
            errors.rejectValue("mobile", "Duplicate.users.mobile");
        }
    }
    
}
