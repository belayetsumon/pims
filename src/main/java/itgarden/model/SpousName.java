/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.District;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class SpousName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotEmpty(message = "This field cannot be blank.")
    private String spouseName;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    private District district;

 
    private String dateofBirth;

    private String birthCertificateNumber;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    private BirthCountry birthCountry;

    @Size(min = 13, max = 17, message = " Please provide value Minimum 13 digit maximum 17 digit")
    private String nid;

    @NotEmpty(message = "This field cannot be blank.")
    private String dateofMarriage;

    private String marriageRegistrationNo;

    private String passportNo;

//    @NotNull(message = "This field cannot be blank.")
//    @Enumerated(EnumType.STRING)
//    private EthnicIdentity ethnicIdentity;

//    @NotEmpty(message = "This field cannot be blank.")
//    private String nationality;

    private String occupation;

    private String organization;

    private String designation;

    private String location;

    @NotNull(message = "Spous contact cannot be blank.")
    @Lob
    private String contact;

    private String remarks;

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

    public SpousName() {
    }

    public SpousName(Long id, Users governmentId, String spouseName, District district, String dateofBirth, String birthCertificateNumber, BirthCountry birthCountry, String nid, String dateofMarriage, String marriageRegistrationNo, String passportNo, String occupation, String organization, String designation, String location, String contact, String remarks, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.spouseName = spouseName;
        this.district = district;
        this.dateofBirth = dateofBirth;
        this.birthCertificateNumber = birthCertificateNumber;
        this.birthCountry = birthCountry;
        this.nid = nid;
        this.dateofMarriage = dateofMarriage;
        this.marriageRegistrationNo = marriageRegistrationNo;
        this.passportNo = passportNo;
        this.occupation = occupation;
        this.organization = organization;
        this.designation = designation;
        this.location = location;
        this.contact = contact;
        this.remarks = remarks;
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

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    public void setBirthCertificateNumber(String birthCertificateNumber) {
        this.birthCertificateNumber = birthCertificateNumber;
    }

    public BirthCountry getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(BirthCountry birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDateofMarriage() {
        return dateofMarriage;
    }

    public void setDateofMarriage(String dateofMarriage) {
        this.dateofMarriage = dateofMarriage;
    }

    public String getMarriageRegistrationNo() {
        return marriageRegistrationNo;
    }

    public void setMarriageRegistrationNo(String marriageRegistrationNo) {
        this.marriageRegistrationNo = marriageRegistrationNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
