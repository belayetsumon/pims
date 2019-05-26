/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Md Belayet Hossin
 */


@Entity
public class ServiceHistories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

 @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotEmpty(message = "This field cannot be blank.")
    private String designation;
    
       @NotEmpty(message = "This field cannot be blank.")
    private String dateEntry; //Date of Entry in Service Life
    
       
    @NotEmpty(message = "This field cannot be blank.")
    private String dateGazette;
    
   @NotEmpty(message = "This field cannot be blank.")
    private String dateEncadrement;  //Date of encadrement
   
      @NotEmpty(message = "This field cannot be blank.")
    private String  cadre;  // Name of Cadre
    
    
 /**
     * ***************** Start Auditor ********************************
     */
//   @Version
    @Column(name = "version")
    private long version;

    @Column(name = "created_on", nullable = false, insertable = true, updatable = false)
    //@CreatedDate
    private Date createdOn = new Date();

    @Column(name = "created_by", insertable = true, updatable = false)
    //@CreatedBy
    private String createdBy;

    @Column(name = "updated_on", insertable = false, updatable = true)
    //@LastModifiedDate
    private Date updatedOn = new Date();

    @Column(name = "updated_by", insertable = false, updatable = true)
    //@LastModifiedBy
    private String updatedBy ;

    /**
     * ***************** End Auditor ********************************
     */

    public ServiceHistories() {
    }

    public ServiceHistories(Long id, Users governmentId, String designation, String dateEntry, String dateGazette, String dateEncadrement, String cadre, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.designation = designation;
        this.dateEntry = dateEntry;
        this.dateGazette = dateGazette;
        this.dateEncadrement = dateEncadrement;
        this.cadre = cadre;
        this.version = version;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(Users governmentId) {
        this.governmentId = governmentId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getDateGazette() {
        return dateGazette;
    }

    public void setDateGazette(String dateGazette) {
        this.dateGazette = dateGazette;
    }

    public String getDateEncadrement() {
        return dateEncadrement;
    }

    public void setDateEncadrement(String dateEncadrement) {
        this.dateEncadrement = dateEncadrement;
    }

    public String getCadre() {
        return cadre;
    }

    public void setCadre(String cadre) {
        this.cadre = cadre;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
