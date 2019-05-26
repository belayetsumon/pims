/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.BloodGroup;
import itgarden.model.enumvalue.District;
import itgarden.model.enumvalue.EmployeeStatus;
import itgarden.model.enumvalue.EthnicIdentity;
import itgarden.model.enumvalue.Gender;
import itgarden.model.enumvalue.MaritalStatus;
import itgarden.model.enumvalue.Religion;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class GeneralInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "*Government Id cannot be blank.")
    @OneToOne(optional = false)
    private Users governmentId;

    @NotEmpty(message = "*Please provide your name")
    private String name;

    @NotEmpty(message = "*Please provide your father's name")
    private String fathersName;

    @NotEmpty(message = "*Please provide your mother's name")
    private String mothersName;

    @NotNull(message = " * Home district cannot be blank.")
    @Enumerated(EnumType.STRING)
    private District homeDistrict;

    @NotEmpty(message = "*Please provide your date of birth.")
    private String dateofBirth;

    @NotNull(message = " *Country of  cannot be blank.")
    @Enumerated(EnumType.STRING)
    private BirthCountry birthCountry;

    @Column(unique = true)
    private String birthCertificateNumber;

    @NotNull(message = "* Gender cannot be blank.")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "*Marital Status  cannot be blank.")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotNull(message = "*Religion cannot be blank.")
    @Enumerated(EnumType.STRING)
    private Religion religion;

    @NotNull(message = "*EthnicIdentity cannot be blank.")
    @Enumerated(EnumType.STRING)
    private EthnicIdentity ethnicIdentity;

    @NotEmpty(message = " *Nationality cannot be blank.")
    private String nationality;

    @NotNull(message = "*Blood Group cannot be blank.")
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private String drivingLicence;

    private String passportNo;

    @NotEmpty(message = "*Please provide your NID number.")
    @Size(min = 13, max = 17, message = " Please provide value Minimum 13 digit maximum 17 digit")
    @Column(unique = true)
    private String nid;
    
     private String tin;

    @NotEmpty(message = "*Please provide your LPR Date")
    private String lPRDate;  // LPR Date

    @NotNull(message = "*Employee Status cannot be blank.")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;  // Employee Status: HOME DEPUTATION

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
    public GeneralInformation() {
    }

    public GeneralInformation(Long id, Users governmentId, String name, String fathersName, String mothersName, District homeDistrict, String dateofBirth, BirthCountry birthCountry, String birthCertificateNumber, Gender gender, MaritalStatus maritalStatus, Religion religion, EthnicIdentity ethnicIdentity, String nationality, BloodGroup bloodGroup, String drivingLicence, String passportNo, String nid, String tin, String lPRDate, EmployeeStatus employeeStatus, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.name = name;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.homeDistrict = homeDistrict;
        this.dateofBirth = dateofBirth;
        this.birthCountry = birthCountry;
        this.birthCertificateNumber = birthCertificateNumber;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.ethnicIdentity = ethnicIdentity;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.drivingLicence = drivingLicence;
        this.passportNo = passportNo;
        this.nid = nid;
        this.tin = tin;
        this.lPRDate = lPRDate;
        this.employeeStatus = employeeStatus;
        this.version = version;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public District getHomeDistrict() {
        return homeDistrict;
    }

    public void setHomeDistrict(District homeDistrict) {
        this.homeDistrict = homeDistrict;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public BirthCountry getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(BirthCountry birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    public void setBirthCertificateNumber(String birthCertificateNumber) {
        this.birthCertificateNumber = birthCertificateNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public EthnicIdentity getEthnicIdentity() {
        return ethnicIdentity;
    }

    public void setEthnicIdentity(EthnicIdentity ethnicIdentity) {
        this.ethnicIdentity = ethnicIdentity;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getlPRDate() {
        return lPRDate;
    }

    public void setlPRDate(String lPRDate) {
        this.lPRDate = lPRDate;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
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
