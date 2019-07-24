/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository;

import itgarden.model.AddressInformation;
import itgarden.model.Users;
import itgarden.model.enumvalue.AddressType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Md Belayet Hossin
 */
public interface AddressInformationRepository extends JpaRepository<AddressInformation, Long> {

    List<AddressInformation> findByGovernmentIdOrderByIdDesc(Users governmentId);

    List<AddressInformation> findAllByOrderByIdDesc();
    
    AddressInformation findByGovernmentIdAndAddressType(Users governmentId, AddressType addressType );
}
