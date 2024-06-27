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
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotEmpty(message = "*Please provide your name bangla")
    private String nameBangla;

    @NotEmpty(message = "*Please provide your father's name")
    private String fathersName;

    @NotEmpty(message = "*Please provide your father's name bangla")
    private String fathersNameBangla;

    @NotEmpty(message = "*Please provide your mother's name")
    private String mothersName;

    @NotEmpty(message = "*Please provide your mother's name bangla")
    private String mothersNameBangla;

    @NotNull(message = " * Home district cannot be blank.")
    @Enumerated(EnumType.STRING)
    private District homeDistrict;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "*Please provide your date of birth.")
    @Past
    private Date dateofBirth;

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

//    @NotEmpty(message = " *Nationality cannot be blank.")
//    private String nationality;

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

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private Date lPRDate;  // LPR Date

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
    private String updatedBy;

    /**
     * ***************** End Auditor ********************************
     */
    public GeneralInformation() {
    }

    public GeneralInformation(Long id, Users governmentId, String name, String nameBangla, String fathersName, String fathersNameBangla, String mothersName, String mothersNameBangla, District homeDistrict, Date dateofBirth, BirthCountry birthCountry, String birthCertificateNumber, Gender gender, MaritalStatus maritalStatus, Religion religion, EthnicIdentity ethnicIdentity, BloodGroup bloodGroup, String drivingLicence, String passportNo, String nid, String tin, Date lPRDate, EmployeeStatus employeeStatus, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.name = name;
        this.nameBangla = nameBangla;
        this.fathersName = fathersName;
        this.fathersNameBangla = fathersNameBangla;
        this.mothersName = mothersName;
        this.mothersNameBangla = mothersNameBangla;
        this.homeDistrict = homeDistrict;
        this.dateofBirth = dateofBirth;
        this.birthCountry = birthCountry;
        this.birthCertificateNumber = birthCertificateNumber;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.religion = religion;
        this.ethnicIdentity = ethnicIdentity;
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

    public String getNameBangla() {
        return nameBangla;
    }

    public void setNameBangla(String nameBangla) {
        this.nameBangla = nameBangla;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getFathersNameBangla() {
        return fathersNameBangla;
    }

    public void setFathersNameBangla(String fathersNameBangla) {
        this.fathersNameBangla = fathersNameBangla;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getMothersNameBangla() {
        return mothersNameBangla;
    }

    public void setMothersNameBangla(String mothersNameBangla) {
        this.mothersNameBangla = mothersNameBangla;
    }

    public District getHomeDistrict() {
        return homeDistrict;
    }

    public void setHomeDistrict(District homeDistrict) {
        this.homeDistrict = homeDistrict;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
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

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public Date getlPRDate() {
        return lPRDate;
    }

    public void setlPRDate(Date lPRDate) {
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
