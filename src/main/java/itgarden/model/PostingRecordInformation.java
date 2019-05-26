/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.PostingReason;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.lookup.PostingDesignation;
import itgarden.model.lookup.PostingRank;
import itgarden.model.lookup.PresentPostingLocation;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class PostingRecordInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotNull(message = " *Posting reason cannot be blank.")
    @Enumerated(EnumType.STRING)
    PostingReason  postingReason;
    
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

    @NotNull(message = " *Country of  cannot be blank.")
    @Enumerated(EnumType.STRING)
    private BirthCountry country;


    @NotEmpty(message = "This field cannot be blank.")
    private String periodFrom;

    private String periodTo;

    private String scale;

    private String status;

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
    public PostingRecordInformation() {
    }

    public PostingRecordInformation(Long id, Users governmentId, PostingReason postingReason, PostingRank postingRank, PostingType postingType, PostingDesignation postingDesignation, PresentPostingLocation postingLocation, BirthCountry country, String periodFrom, String periodTo, String scale, String status, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.postingReason = postingReason;
        this.postingRank = postingRank;
        this.postingType = postingType;
        this.postingDesignation = postingDesignation;
        this.postingLocation = postingLocation;
        this.country = country;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.scale = scale;
        this.status = status;
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

    public PostingReason getPostingReason() {
        return postingReason;
    }

    public void setPostingReason(PostingReason postingReason) {
        this.postingReason = postingReason;
    }

    public PostingRank getPostingRank() {
        return postingRank;
    }

    public void setPostingRank(PostingRank postingRank) {
        this.postingRank = postingRank;
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

    public PresentPostingLocation getPostingLocation() {
        return postingLocation;
    }

    public void setPostingLocation(PresentPostingLocation postingLocation) {
        this.postingLocation = postingLocation;
    }

    
    public BirthCountry getCountry() {
        return country;
    }

    public void setCountry(BirthCountry country) {
        this.country = country;
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

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
