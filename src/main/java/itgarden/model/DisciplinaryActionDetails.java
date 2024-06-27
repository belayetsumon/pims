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
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class DisciplinaryActionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = " Order date cannot be blank.")
    private Date oderDate;

    @NotEmpty(message = "This field cannot be blank.")
    private String natureofOffence;

    @NotEmpty(message = "This field cannot be blank.")
    private String punishmentNature;

    @NotEmpty(message = "This field cannot be blank.")
    private String punishment;

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

    public DisciplinaryActionDetails() {
    }

    public DisciplinaryActionDetails(Long id, Users governmentId, Date oderDate, String natureofOffence, String punishmentNature, String punishment, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.oderDate = oderDate;
        this.natureofOffence = natureofOffence;
        this.punishmentNature = punishmentNature;
        this.punishment = punishment;
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

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public String getNatureofOffence() {
        return natureofOffence;
    }

    public void setNatureofOffence(String natureofOffence) {
        this.natureofOffence = natureofOffence;
    }

    public String getPunishmentNature() {
        return punishmentNature;
    }

    public void setPunishmentNature(String punishmentNature) {
        this.punishmentNature = punishmentNature;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
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
