/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository;

import itgarden.model.PublicationInformation;
import itgarden.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Md Belayet Hossin
 */
public interface PublicationInformationRepository extends JpaRepository<PublicationInformation, Long> {

    List<PublicationInformation> findByGovernmentIdOrderByIdDesc(Users governmentId);

    List<PublicationInformation> findAllByOrderByIdDesc();
}
