/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.PostingType;
import itgarden.model.lookup.PostingDesignation;
import itgarden.model.lookup.PostingRank;
import itgarden.model.lookup.PresentPostingLocation;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class Acr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private PostingRank postingRank;  // Present Posting Rank  : DY. SECRETARY

    @NotNull(message = " *Posting type cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private PostingType postingType;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = false)
    private PostingDesignation postingDesignation;

    @NotNull(message = "Present posting  location cannot be blank.")
    @ManyToOne(optional = false)
    private PresentPostingLocation postingLocation;  // DHAKA

    @NotNull(message = "This field cannot be blank.")
    private int year;

    @NotEmpty(message = "This field cannot be blank.")
    private String periodFrom;

    @NotEmpty(message = "This field cannot be blank.")
    private String periodTo;

    private String signatoryOfficer;
    
    private String signatoryOfficerName;
    
    private String authorizedOfficer;

    private String authorizedOfficerName;
    
    @NotEmpty(message = "This field cannot be blank.")
    private String mark;
    
    
     private String fileName;
    
    private String remarks;

    /**
     * ********* Audit ******************************
     *
     */
    @Column(insertable = true, updatable = false)
    public LocalDate created = LocalDate.now();

    @Column(insertable = true, updatable = false)
    public String createdBy;

    @Column(insertable = false, updatable = true)
    public LocalDate updated = LocalDate.now();

    @Column(insertable = false, updatable = true)
    public String updatedBy;

    public Acr() {
    }

    public Acr(Long id, Users governmentId, PostingRank postingRank, PostingType postingType, PostingDesignation postingDesignation, PresentPostingLocation postingLocation, int year, String periodFrom, String periodTo, String signatoryOfficer, String signatoryOfficerName, String authorizedOfficer, String authorizedOfficerName, String mark, String fileName, String remarks, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.postingRank = postingRank;
        this.postingType = postingType;
        this.postingDesignation = postingDesignation;
        this.postingLocation = postingLocation;
        this.year = year;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.signatoryOfficer = signatoryOfficer;
        this.signatoryOfficerName = signatoryOfficerName;
        this.authorizedOfficer = authorizedOfficer;
        this.authorizedOfficerName = authorizedOfficerName;
        this.mark = mark;
        this.fileName = fileName;
        this.remarks = remarks;
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

    public PostingType getPostingType() {
        return postingType;
    }

    public void setPostingType(PostingType postingType) {
        this.postingType = postingType;
    }

    public PostingDesignation getPostingDesignation() {
        return postingDesignation;
    }

    public void setPostingDesignation(PostingDesignation postingDesignation) {
        this.postingDesignation = postingDesignation;
    }

    public PostingRank getPostingRank() {
        return postingRank;
    }

    public void setPostingRank(PostingRank postingRank) {
        this.postingRank = postingRank;
    }

    public PresentPostingLocation getPostingLocation() {
        return postingLocation;
    }

    public void setPostingLocation(PresentPostingLocation postingLocation) {
        this.postingLocation = postingLocation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(String periodTo) {
        this.periodTo = periodTo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getSignatoryOfficer() {
        return signatoryOfficer;
    }

    public void setSignatoryOfficer(String signatoryOfficer) {
        this.signatoryOfficer = signatoryOfficer;
    }

    public String getSignatoryOfficerName() {
        return signatoryOfficerName;
    }

    public void setSignatoryOfficerName(String signatoryOfficerName) {
        this.signatoryOfficerName = signatoryOfficerName;
    }

    public String getAuthorizedOfficer() {
        return authorizedOfficer;
    }

    public void setAuthorizedOfficer(String authorizedOfficer) {
        this.authorizedOfficer = authorizedOfficer;
    }

    public String getAuthorizedOfficerName() {
        return authorizedOfficerName;
    }

    public void setAuthorizedOfficerName(String authorizedOfficerName) {
        this.authorizedOfficerName = authorizedOfficerName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
