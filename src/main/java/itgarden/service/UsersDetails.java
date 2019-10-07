/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.service;
import itgarden.model.Users;
import itgarden.model.lookup.Role;
import itgarden.model.enumvalue.Status;
import itgarden.model.lookup.Privilege;
import itgarden.repository.UsersRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Md Belayet Hossin
 */
@Service
public class UsersDetails implements UserDetailsService{
    @Autowired
    private UsersRepository usersRepository;

    //String governmentId= "123456";
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Users user = usersRepository.findByGovernmentIdAndStatus(username, Status.Active);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
//        Set<Role> userrole=user.getRole();
//        for (Role role : userrole ){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        
        
         for (Role role : user.getRole()) {
            
            for( Privilege privilegelist : role.getPrivilege())
            {
            grantedAuthorities.add(new SimpleGrantedAuthority( privilegelist.getSlug()));
            }
            
        }
        
        return new org.springframework.security.core.userdetails.User(user.getGovernmentId(), user.getPassword(), grantedAuthorities);
    }

}
