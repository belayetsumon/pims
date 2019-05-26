/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.PostingReason;
import itgarden.model.lookup.PostingDesignation;
import itgarden.model.lookup.PostingRank;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.lookup.PresentPostingLocation;
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

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class PresentJob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Government Id cannot be blank.")
    @ManyToOne(optional = false)
    private Users governmentId;
    
    @NotNull(message = " *Posting reason cannot be blank.")
    @Enumerated(EnumType.STRING)
    PostingReason  postingReason;

    @NotNull(message = " *Posting type cannot be blank.")
    @Enumerated(EnumType.STRING)
    private PostingType postingType;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = false)
    private PostingDesignation postingDesignation;

    @NotNull(message = "Present posting  location cannot be blank.")
    @ManyToOne(optional = false)
    private PresentPostingLocation presentPostingLocation;  // DHAKA

    private String dateJoining;

    private String dateofGazetted;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private PostingRank presentPostingRank;  // Present Posting Rank  : DY. SECRETARY

    private String grade;
    
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
    public PresentJob() {
    }

    public PresentJob(Long id, Users governmentId, PostingReason postingReason, PostingType postingType, PostingDesignation postingDesignation, PresentPostingLocation presentPostingLocation, String dateJoining, String dateofGazetted, PostingRank presentPostingRank, String grade, String remarks, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.postingReason = postingReason;
        this.postingType = postingType;
        this.postingDesignation = postingDesignation;
        this.presentPostingLocation = presentPostingLocation;
        this.dateJoining = dateJoining;
        this.dateofGazetted = dateofGazetted;
        this.presentPostingRank = presentPostingRank;
        this.grade = grade;
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

    public PostingReason getPostingReason() {
        return postingReason;
    }

    public void setPostingReason(PostingReason postingReason) {
        this.postingReason = postingReason;
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

    public PresentPostingLocation getPresentPostingLocation() {
        return presentPostingLocation;
    }

    public void setPresentPostingLocation(PresentPostingLocation presentPostingLocation) {
        this.presentPostingLocation = presentPostingLocation;
    }



    public String getDateJoining() {
        return dateJoining;
    }

    public void setDateJoining(String dateJoining) {
        this.dateJoining = dateJoining;
    }

    public String getDateofGazetted() {
        return dateofGazetted;
    }

    public void setDateofGazetted(String dateofGazetted) {
        this.dateofGazetted = dateofGazetted;
    }

    public PostingRank getPresentPostingRank() {
        return presentPostingRank;
    }

    public void setPresentPostingRank(PostingRank presentPostingRank) {
        this.presentPostingRank = presentPostingRank;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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