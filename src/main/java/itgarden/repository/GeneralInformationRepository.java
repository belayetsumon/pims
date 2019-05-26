/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository;

import itgarden.model.GeneralInformation;
import itgarden.model.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Md Belayet Hossin
 */
public interface GeneralInformationRepository extends JpaRepository<GeneralInformation, Long> {

    List<GeneralInformation> findByGovernmentIdOrderByIdDesc(Users governmentId);

    List<GeneralInformation> findAllByOrderByIdDesc();
    
}
