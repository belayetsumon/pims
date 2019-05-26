/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.EthnicIdentity;
import itgarden.model.enumvalue.Gender;
import itgarden.model.enumvalue.MaritalStatus;
import itgarden.model.enumvalue.PsychicalStatus;
import itgarden.model.enumvalue.YesNo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class ChildrenInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotEmpty(message = "This field cannot be blank.")
    private String childName;

    @NotEmpty(message = "This field cannot be blank.")
    private String dateofBirth;

    private String birthCertificateNumber;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    private BirthCountry birthCountry;

    @Size(min = 13, max = 17, message = " Please provide value Minimum 13 digit maximum 17 digit")
    private String nid;

    private String passportNo;

    @NotNull(message = "This field cannot be blank.")
   @Enumerated(EnumType.STRING)
    private EthnicIdentity ethnicIdentity;

  
    private String nationality;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    PsychicalStatus psychicalStatus;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    YesNo schooling;

    @NotEmpty(message = "This field cannot be blank.")
    private String educationLevel;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;

    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    YesNo emplyment;

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
    private String updatedBy ;
    
     /**
     * ***************** End Auditor ********************************
     */

    public ChildrenInformation(Long id, Users governmentId, String childName, String dateofBirth, String birthCertificateNumber, BirthCountry birthCountry, String nid, String passportNo, EthnicIdentity ethnicIdentity, String nationality, Gender gender, PsychicalStatus psychicalStatus, YesNo schooling, String educationLevel, MaritalStatus maritalStatus, YesNo emplyment, String remarks, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.childName = childName;
        this.dateofBirth = dateofBirth;
        this.birthCertificateNumber = birthCertificateNumber;
        this.birthCountry = birthCountry;
        this.nid = nid;
        this.passportNo = passportNo;
        this.ethnicIdentity = ethnicIdentity;
        this.nationality = nationality;
        this.gender = gender;
        this.psychicalStatus = psychicalStatus;
        this.schooling = schooling;
        this.educationLevel = educationLevel;
        this.maritalStatus = maritalStatus;
        this.emplyment = emplyment;
        this.remarks = remarks;
        this.version = version;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public ChildrenInformation() {
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

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
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

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PsychicalStatus getPsychicalStatus() {
        return psychicalStatus;
    }

    public void setPsychicalStatus(PsychicalStatus psychicalStatus) {
        this.psychicalStatus = psychicalStatus;
    }

    public YesNo getSchooling() {
        return schooling;
    }

    public void setSchooling(YesNo schooling) {
        this.schooling = schooling;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public YesNo getEmplyment() {
        return emplyment;
    }

    public void setEmplyment(YesNo emplyment) {
        this.emplyment = emplyment;
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
