/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.BirthCountry;
import itgarden.model.enumvalue.PostingType;
import itgarden.model.enumvalue.PromotionNature;
import itgarden.model.lookup.PostingDesignation;
import itgarden.model.lookup.PostingRank;
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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class PromotionsInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotEmpty(message = "This field cannot be blank.")
    private String dateofPromotion;

    @NotEmpty(message = "This field cannot be blank.")
    private String govtOrderDate;

    @NotNull(message = " * Nature Of Promotions reason cannot be blank.")
    @Enumerated(EnumType.STRING)
    private PromotionNature  natureOfPromotions;

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

    private String scale;
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
    public PromotionsInformation() {
    }

    public PromotionsInformation(Long id, Users governmentId, String dateofPromotion, String govtOrderDate, PromotionNature natureOfPromotions, PostingRank postingRank, PostingType postingType, PostingDesignation postingDesignation, PresentPostingLocation postingLocation, BirthCountry country, String scale, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.dateofPromotion = dateofPromotion;
        this.govtOrderDate = govtOrderDate;
        this.natureOfPromotions = natureOfPromotions;
        this.postingRank = postingRank;
        this.postingType = postingType;
        this.postingDesignation = postingDesignation;
        this.postingLocation = postingLocation;
        this.country = country;
        this.scale = scale;
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

    public String getDateofPromotion() {
        return dateofPromotion;
    }

    public void setDateofPromotion(String dateofPromotion) {
        this.dateofPromotion = dateofPromotion;
    }

    public String getGovtOrderDate() {
        return govtOrderDate;
    }

    public void setGovtOrderDate(String govtOrderDate) {
        this.govtOrderDate = govtOrderDate;
    }

    public PromotionNature getNatureOfPromotions() {
        return natureOfPromotions;
    }

    public void setNatureOfPromotions(PromotionNature natureOfPromotions) {
        this.natureOfPromotions = natureOfPromotions;
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

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
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
