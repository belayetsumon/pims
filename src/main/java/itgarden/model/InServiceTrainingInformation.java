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
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */

@Entity
public class InServiceTrainingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotEmpty(message = "This field cannot be blank.")
    private String trainingTitle;

    @NotEmpty(message = "This field cannot be blank.")
    private String trainingType;

    @NotEmpty(message = "This field cannot be blank.")
    private String trainingInstitute;

    @NotEmpty(message = "This field cannot be blank.")
    private String position;

    @NotEmpty(message = "This field cannot be blank.")
    private String periodFrom;

    @NotEmpty(message = "This field cannot be blank.")
    private String periodTo;


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

    public InServiceTrainingInformation(Long id, Users governmentId, String trainingTitle, String trainingType, String trainingInstitute, String position, String periodFrom, String periodTo, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.trainingTitle = trainingTitle;
        this.trainingType = trainingType;
        this.trainingInstitute = trainingInstitute;
        this.position = position;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.version = version;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public InServiceTrainingInformation() {
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

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getTrainingInstitute() {
        return trainingInstitute;
    }

    public void setTrainingInstitute(String trainingInstitute) {
        this.trainingInstitute = trainingInstitute;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
