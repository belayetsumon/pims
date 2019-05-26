/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.LeaveType;
import itgarden.model.enumvalue.Status;
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
public class Leaveinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = true)
    private Users governmentId;

    @NotEmpty(message = "This field cannot be blank.")
    private String governmentOrderNo;

    @NotNull(message = "*Marital Status  cannot be blank.")
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private String leaveApprovedLength;  // Day

    @NotEmpty(message = "This field cannot be blank.")
    private String leaveStartDate;

    @NotEmpty(message = "This field cannot be blank.")
    private String joinDate;

    private String totalEnjoyDay;

    @Enumerated(EnumType.STRING)
    
    private Status status;
    
    private String remark;

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

    public Leaveinfo() {
    }

    public Leaveinfo(Long id, Users governmentId, String governmentOrderNo, LeaveType leaveType, String leaveApprovedLength, String leaveStartDate, String joinDate, String totalEnjoyDay, Status status, String remark, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.governmentOrderNo = governmentOrderNo;
        this.leaveType = leaveType;
        this.leaveApprovedLength = leaveApprovedLength;
        this.leaveStartDate = leaveStartDate;
        this.joinDate = joinDate;
        this.totalEnjoyDay = totalEnjoyDay;
        this.status = status;
        this.remark = remark;
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

    public String getGovernmentOrderNo() {
        return governmentOrderNo;
    }

    public void setGovernmentOrderNo(String governmentOrderNo) {
        this.governmentOrderNo = governmentOrderNo;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveApprovedLength() {
        return leaveApprovedLength;
    }

    public void setLeaveApprovedLength(String leaveApprovedLength) {
        this.leaveApprovedLength = leaveApprovedLength;
    }

    public String getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(String leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getTotalEnjoyDay() {
        return totalEnjoyDay;
    }

    public void setTotalEnjoyDay(String totalEnjoyDay) {
        this.totalEnjoyDay = totalEnjoyDay;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    /**
     * ***************** End Auditor ********************************
     */

    
    
    
}