/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository;

import itgarden.model.Membership;
import itgarden.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Md Belayet Hossin
 */
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    
      List<Membership> findByGovernmentIdOrderByIdDesc(Users governmentId);

    List<Membership> findAllByOrderByIdDesc();
    
}
