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
public class EducationalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotEmpty(message = "Name of Institution field cannot be blank.")
    private String nameOfInstitution;

    private String principalSubject;

    @NotEmpty(message = "Certificate / degree field cannot be blank.")
    private String certificateDegree;

    @NotEmpty(message = "Year field cannot be blank.")
    private String year;
    
     @NotEmpty(message = "Board or University field cannot be blank.")
    private String boardoruniversity;
    
    private String divisionClass;
    
    private String gPA;
    
    private String gPAPoint;
    
    private String distinction;

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

    
        public EducationalInformation() {
    }

    public EducationalInformation(Long id, Users governmentId, String nameOfInstitution, String principalSubject, String certificateDegree, String year, String boardoruniversity, String divisionClass, String gPA, String gPAPoint, String distinction, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.nameOfInstitution = nameOfInstitution;
        this.principalSubject = principalSubject;
        this.certificateDegree = certificateDegree;
        this.year = year;
        this.boardoruniversity = boardoruniversity;
        this.divisionClass = divisionClass;
        this.gPA = gPA;
        this.gPAPoint = gPAPoint;
        this.distinction = distinction;
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

    public String getNameOfInstitution() {
        return nameOfInstitution;
    }

    public void setNameOfInstitution(String nameOfInstitution) {
        this.nameOfInstitution = nameOfInstitution;
    }

    public String getPrincipalSubject() {
        return principalSubject;
    }

    public void setPrincipalSubject(String principalSubject) {
        this.principalSubject = principalSubject;
    }

    public String getCertificateDegree() {
        return certificateDegree;
    }

    public void setCertificateDegree(String certificateDegree) {
        this.certificateDegree = certificateDegree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBoardoruniversity() {
        return boardoruniversity;
    }

    public void setBoardoruniversity(String boardoruniversity) {
        this.boardoruniversity = boardoruniversity;
    }

    public String getDivisionClass() {
        return divisionClass;
    }

    public void setDivisionClass(String divisionClass) {
        this.divisionClass = divisionClass;
    }

    public String getgPA() {
        return gPA;
    }

    public void setgPA(String gPA) {
        this.gPA = gPA;
    }

    public String getgPAPoint() {
        return gPAPoint;
    }

    public void setgPAPoint(String gPAPoint) {
        this.gPAPoint = gPAPoint;
    }

    public String getDistinction() {
        return distinction;
    }

    public void setDistinction(String distinction) {
        this.distinction = distinction;
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
