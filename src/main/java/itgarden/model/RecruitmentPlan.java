/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.lookup.Department;
import itgarden.model.lookup.PostingDesignation;
import itgarden.model.lookup.SubDepartment;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Entity
public class RecruitmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Depertment  cannot be blank.")
    @ManyToOne(optional = false)
    private Department department;

    @NotNull(message = " Subdepartment cannot be blank.")
    @ManyToOne(optional = false)
    private SubDepartment subDepartment;

    @NotNull(message = "Designation cannot be blank.")
    @ManyToOne(optional = false)
    private PostingDesignation postingDesignation;

    @NotNull(message = "Quantity cannot be blank.")

    private int qty;

    @Lob
    private String remanrk;

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

    public RecruitmentPlan() {
    }

    public RecruitmentPlan(Long id, Department department, SubDepartment subDepartment, PostingDesignation postingDesignation, int qty, String remanrk, String createdBy, String updatedBy) {
        this.id = id;
        this.department = department;
        this.subDepartment = subDepartment;
        this.postingDesignation = postingDesignation;
        this.qty = qty;
        this.remanrk = remanrk;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SubDepartment getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(SubDepartment subDepartment) {
        this.subDepartment = subDepartment;
    }

    public PostingDesignation getPostingDesignation() {
        return postingDesignation;
    }

    public void setPostingDesignation(PostingDesignation postingDesignation) {
        this.postingDesignation = postingDesignation;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getRemanrk() {
        return remanrk;
    }

    public void setRemanrk(String remanrk) {
        this.remanrk = remanrk;
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
