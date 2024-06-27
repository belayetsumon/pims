/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.PostingType;
import itgarden.model.enumvalue.Selectiongrade;
import itgarden.model.lookup.PostingDesignation;
import itgarden.model.lookup.PresentPostingLocation;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class FirstJoiningInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @OneToOne(optional = false)
    private Users governmentId;

    

    @NotNull(message = " *Posting type cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private PostingType postingType;

    @NotNull(message = " *Designation cannot be blank.")
    @ManyToOne(optional = false)
    private PostingDesignation firstPostingDesignation;

    @NotNull(message = "First joining office location cannot be blank.")
    @ManyToOne(optional = false)
    private PresentPostingLocation firstJoiningOfficeLocation;

   
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    
    private Date dateFirstJoining;

    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateofGazetted;

    @NotNull(message = " *Grade  cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private Selectiongrade grade;

    private String remarks;

    /**
     * ***************** Start Auditor ********************************
     */
//   @Version
//    @Column(name = "version")
//    private long version;

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

    public FirstJoiningInformation(Long id, Users governmentId, PostingType postingType, PostingDesignation firstPostingDesignation, PresentPostingLocation firstJoiningOfficeLocation, Date dateFirstJoining, Date dateofGazetted, Selectiongrade grade, String remarks, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.postingType = postingType;
        this.firstPostingDesignation = firstPostingDesignation;
        this.firstJoiningOfficeLocation = firstJoiningOfficeLocation;
        this.dateFirstJoining = dateFirstJoining;
        this.dateofGazetted = dateofGazetted;
        this.grade = grade;
        this.remarks = remarks;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public FirstJoiningInformation() {
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

    public PostingType getPostingType() {
        return postingType;
    }

    public void setPostingType(PostingType postingType) {
        this.postingType = postingType;
    }

    public PostingDesignation getFirstPostingDesignation() {
        return firstPostingDesignation;
    }

    public void setFirstPostingDesignation(PostingDesignation firstPostingDesignation) {
        this.firstPostingDesignation = firstPostingDesignation;
    }

    public PresentPostingLocation getFirstJoiningOfficeLocation() {
        return firstJoiningOfficeLocation;
    }

    public void setFirstJoiningOfficeLocation(PresentPostingLocation firstJoiningOfficeLocation) {
        this.firstJoiningOfficeLocation = firstJoiningOfficeLocation;
    }

    public Date getDateFirstJoining() {
        return dateFirstJoining;
    }

    public void setDateFirstJoining(Date dateFirstJoining) {
        this.dateFirstJoining = dateFirstJoining;
    }

    public Date getDateofGazetted() {
        return dateofGazetted;
    }

    public void setDateofGazetted(Date dateofGazetted) {
        this.dateofGazetted = dateofGazetted;
    }

    public Selectiongrade getGrade() {
        return grade;
    }

    public void setGrade(Selectiongrade grade) {
        this.grade = grade;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
