/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */

@Entity
public class OrganizationProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "This field cannot be blank.")
    private String name;

    @NotEmpty(message = "This field cannot be blank.")
    private String address;
    
    
  @NotEmpty(message = "This field cannot be blank.")
    private String contact;
  
  @NotEmpty(message = "This field cannot be blank.")
    private String systemAdminContact;
  
  
   private String logoname;
  
  
}
