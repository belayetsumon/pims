/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository;

import itgarden.model.HonorsAndAwardInformation;
import itgarden.model.InServiceTrainingInformation;
import itgarden.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Md Belayet Hossin
 */
public interface InServiceTrainingInformationRepository extends JpaRepository<InServiceTrainingInformation, Long> {

    List<InServiceTrainingInformation> findByGovernmentIdOrderByIdDesc(Users governmentId);

    List<InServiceTrainingInformation> findAllByOrderByIdDesc();
}
