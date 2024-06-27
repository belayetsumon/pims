/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class AddressInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne
    private Users governmentId;

//    @NotNull(message = "Address type field cannot be blank.")
//    @Enumerated(EnumType.STRING)
//    private AddressType addressType;
//
//    @NotEmpty(message = "Village field cannot be blank.")
//    private String village;
//
//    @NotEmpty(message = "Post office field cannot be blank.")
//    private String postOffice;
//
//    @NotNull(message = " District field cannot be blank.")
//    @Enumerated(EnumType.STRING)
//    private District district;
//
//    @NotNull(message = "Upazila field cannot be blank.")
//    @ManyToOne(optional = false)
//    private Thana upazila;
    
    
    @NotNull(message = " Present address field cannot be blank.")
    @Lob
    private String presentAddress;

    @Lob
    private String permanentAddress;

    @Lob
    private String officialAddress;

    @Email(message = "Please provide a valid email.")
    private String email;

    @Email(message = "Please provide a valid email.")
    private String webmail;

    private String mobile;

    private String telphone;

    private String fax;

    private String pabx;

    private String facebookId;

    private String linkdin;

    private String whatup;

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
    public AddressInformation() {
    }

    public AddressInformation(Long id, Users governmentId, String presentAddress, String permanentAddress, String officialAddress, String email, String webmail, String mobile, String telphone, String fax, String pabx, String facebookId, String linkdin, String whatup, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.officialAddress = officialAddress;
        this.email = email;
        this.webmail = webmail;
        this.mobile = mobile;
        this.telphone = telphone;
        this.fax = fax;
        this.pabx = pabx;
        this.facebookId = facebookId;
        this.linkdin = linkdin;
        this.whatup = whatup;
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

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(String officialAddress) {
        this.officialAddress = officialAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebmail() {
        return webmail;
    }

    public void setWebmail(String webmail) {
        this.webmail = webmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPabx() {
        return pabx;
    }

    public void setPabx(String pabx) {
        this.pabx = pabx;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getLinkdin() {
        return linkdin;
    }

    public void setLinkdin(String linkdin) {
        this.linkdin = linkdin;
    }

    public String getWhatup() {
        return whatup;
    }

    public void setWhatup(String whatup) {
        this.whatup = whatup;
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
