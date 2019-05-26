/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model;

import itgarden.model.enumvalue.Authority;
import itgarden.model.enumvalue.ExamType;
import itgarden.model.enumvalue.PostType;
import itgarden.model.lookup.PostingDesignation;
import itgarden.model.enumvalue.Quota;
import itgarden.model.enumvalue.SelectionType;
import itgarden.model.enumvalue.Selectiongrade;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
public class JobEntryProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @OneToOne(optional = false)
    private Users governmentId;

    @NotNull(message = " *Authority  cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private Authority authority;

    @NotNull(message = "*Designation cannot be blank.")
    @ManyToOne(optional = true)
    private PostingDesignation designation;

    @NotNull(message = " *Exam Type  cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private PostType postType;

    @NotNull(message = " *Exam Type  cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private ExamType examType;

    @NotNull(message = " *Grade  cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private Selectiongrade grade;

    private String batch;

    private String examTitle;

    private String examGovernmentOrderNo;

    private String examDate;

    private String resultDate;

    private String meritNo;

    @NotNull(message = " * Selection Type   cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private SelectionType selectionType;

    @NotNull(message = " * Selection Type   cannot be blank.")
    @Enumerated(EnumType.ORDINAL)
    private Quota quota;

    private String jobConfirmationDate;

    private String jobConfirmationOrderNo;

    private String jobConfirmationSerialNo;

    private String freedomFighterCertificateNo;

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

    public JobEntryProcess() {
    }

    public JobEntryProcess(Long id, Users governmentId, Authority authority, PostingDesignation designation, PostType postType, ExamType examType, Selectiongrade grade, String batch, String examTitle, String examGovernmentOrderNo, String examDate, String resultDate, String meritNo, SelectionType selectionType, Quota quota, String jobConfirmationDate, String jobConfirmationOrderNo, String jobConfirmationSerialNo, String freedomFighterCertificateNo, long version, String createdBy, String updatedBy) {
        this.id = id;
        this.governmentId = governmentId;
        this.authority = authority;
        this.designation = designation;
        this.postType = postType;
        this.examType = examType;
        this.grade = grade;
        this.batch = batch;
        this.examTitle = examTitle;
        this.examGovernmentOrderNo = examGovernmentOrderNo;
        this.examDate = examDate;
        this.resultDate = resultDate;
        this.meritNo = meritNo;
        this.selectionType = selectionType;
        this.quota = quota;
        this.jobConfirmationDate = jobConfirmationDate;
        this.jobConfirmationOrderNo = jobConfirmationOrderNo;
        this.jobConfirmationSerialNo = jobConfirmationSerialNo;
        this.freedomFighterCertificateNo = freedomFighterCertificateNo;
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

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public PostingDesignation getDesignation() {
        return designation;
    }

    public void setDesignation(PostingDesignation designation) {
        this.designation = designation;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public Selectiongrade getGrade() {
        return grade;
    }

    public void setGrade(Selectiongrade grade) {
        this.grade = grade;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public String getExamGovernmentOrderNo() {
        return examGovernmentOrderNo;
    }

    public void setExamGovernmentOrderNo(String examGovernmentOrderNo) {
        this.examGovernmentOrderNo = examGovernmentOrderNo;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public String getMeritNo() {
        return meritNo;
    }

    public void setMeritNo(String meritNo) {
        this.meritNo = meritNo;
    }

    public SelectionType getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(SelectionType selectionType) {
        this.selectionType = selectionType;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public String getJobConfirmationDate() {
        return jobConfirmationDate;
    }

    public void setJobConfirmationDate(String jobConfirmationDate) {
        this.jobConfirmationDate = jobConfirmationDate;
    }

    public String getJobConfirmationOrderNo() {
        return jobConfirmationOrderNo;
    }

    public void setJobConfirmationOrderNo(String jobConfirmationOrderNo) {
        this.jobConfirmationOrderNo = jobConfirmationOrderNo;
    }

    public String getJobConfirmationSerialNo() {
        return jobConfirmationSerialNo;
    }

    public void setJobConfirmationSerialNo(String jobConfirmationSerialNo) {
        this.jobConfirmationSerialNo = jobConfirmationSerialNo;
    }

    public String getFreedomFighterCertificateNo() {
        return freedomFighterCertificateNo;
    }

    public void setFreedomFighterCertificateNo(String freedomFighterCertificateNo) {
        this.freedomFighterCertificateNo = freedomFighterCertificateNo;
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
