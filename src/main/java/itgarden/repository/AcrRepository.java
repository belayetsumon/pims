/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository;

import itgarden.model.Acr;
import itgarden.model.AdditionalQualification;
import itgarden.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Md Belayet Hossin
 */
public interface AcrRepository extends JpaRepository<Acr, Long> {

    List<Acr> findByGovernmentIdOrderByIdDesc(Users governmentId);

    List<Acr> findAllByOrderByIdDesc();
    
    /**
     *
     * @param Id
     * @return
     */
    Acr findById( Acr Id);

}
