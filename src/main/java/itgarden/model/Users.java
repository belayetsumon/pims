package itgarden.model;

import itgarden.model.lookup.Department;
import itgarden.model.lookup.Role;
import itgarden.model.enumvalue.Status;
import itgarden.model.lookup.SubDepartment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "employee")
@DynamicUpdate
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "*Please provide an ID")
    @Column(updatable = false)
    private String governmentId;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;

    @Column(name = "email", unique = true)
    @Email(message = "*Please provide a valid Email")
    private String email;

     private String mobile;

    @Column(length = 60)
    private String password;

    @NotNull(message = "Depertment  cannot be blank.")
    @ManyToOne(optional = false)
    private Department department;

    @NotNull(message = " Subdepartment cannot be blank.")
    @ManyToOne(optional = false)
    private SubDepartment subDepartment;

    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> role;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Lob
    private String remarks;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "last_loginout")
    private Date lastLogOut;

    /**
     * ***************** Start Auditor ********************************
     */
    //@Version
    @Column(name = "version")
    private long version = 1L;

    @Column(name = "created_on", nullable = false, insertable = true, updatable = false)
    //  @CreatedDate
    private Date createdOn = new Date();

    @Column(name = "created_by", insertable = true, updatable = false)
    // @CreatedBy
    private String createdBy;

    @Column(name = "updated_on", insertable = false, updatable = true)
    //@LastModifiedDate
    private Date updatedOn;

    @Column(name = "updated_by", insertable = false, updatable = true)
    //  @LastModifiedBy
    private String updatedBy;

    /**
     * ***************** End Auditor ********************************
     *
     *
     *
     *
     *
     *
     */
    /* Start Relations */
    //@LazyCollection(LazyCollectionOption.TRUE)
    @OneToOne(mappedBy = "governmentId", fetch = FetchType.EAGER)
    public GeneralInformation generalInformation;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(mappedBy = "governmentId") 
    public ProfileImage profileImage;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<AdditionalQualification> additionalQualification;


   @OneToMany(fetch = FetchType.EAGER,mappedBy = "governmentId")
    public List<AddressInformation> addressInformation = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<ChildrenInformation> childrenInformation;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<DisciplinaryActionDetails> disciplinaryActionDetails;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<EducationalInformation> educationalInformation;
//
//    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(mappedBy = "governmentId",fetch = FetchType.EAGER)
    public FirstJoiningInformation firstJoiningInformation;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<ForeignTrainingInformation> foreignTrainingInformation;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<ForeignTravel> foreignTravel;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<HonorsAndAwardInformation> honorsandaward;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<InServiceTrainingInformation> inServiceTrainingInformation;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(mappedBy = "governmentId")
    public JobEntryProcess jobEntryProcess;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<LanguageInformation> languageinfo;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<Leaveinfo> leaveinfo;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<MagisterialPower> magisterialPower;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<Membership> membership;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<OtherServiceInformation> otherServiceInformation;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<PostingAbroadInformation> postingAbroadInformation;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<PostingRecordInformation> postingRecordInformation;
//
    
     @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<Acr> acr;
     //
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(mappedBy = "governmentId")
    public PresentJob presentJob;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<PromotionsInformation> promotionsInformation;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<PublicationInformation> publicationInformation;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToOne(mappedBy = "governmentId")
    public RetirementPension retirementPension;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<SelectionGrade> selectionGrade;
//
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "governmentId")
    public List<SpousName> spousName;

    /*  End Relations */

    public Users(Long id, String governmentId, String name, String email, String mobile, String password, Department department, SubDepartment subDepartment, Set<Role> role, Status status, String remarks, Date lastLogin, Date lastLogOut, String createdBy, Date updatedOn, String updatedBy, GeneralInformation generalInformation, ProfileImage profileImage, List<AdditionalQualification> additionalQualification, List<ChildrenInformation> childrenInformation, List<DisciplinaryActionDetails> disciplinaryActionDetails, List<EducationalInformation> educationalInformation, FirstJoiningInformation firstJoiningInformation, List<ForeignTrainingInformation> foreignTrainingInformation, List<ForeignTravel> foreignTravel, List<HonorsAndAwardInformation> honorsandaward, List<InServiceTrainingInformation> inServiceTrainingInformation, JobEntryProcess jobEntryProcess, List<LanguageInformation> languageinfo, List<Leaveinfo> leaveinfo, List<MagisterialPower> magisterialPower, List<Membership> membership, List<OtherServiceInformation> otherServiceInformation, List<PostingAbroadInformation> postingAbroadInformation, List<PostingRecordInformation> postingRecordInformation, List<Acr> acr, PresentJob presentJob, List<PromotionsInformation> promotionsInformation, List<PublicationInformation> publicationInformation, RetirementPension retirementPension, List<SelectionGrade> selectionGrade, List<SpousName> spousName) {
        this.id = id;
        this.governmentId = governmentId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.department = department;
        this.subDepartment = subDepartment;
        this.role = role;
        this.status = status;
        this.remarks = remarks;
        this.lastLogin = lastLogin;
        this.lastLogOut = lastLogOut;
        this.createdBy = createdBy;
        this.updatedOn = updatedOn;
        this.updatedBy = updatedBy;
        this.generalInformation = generalInformation;
        this.profileImage = profileImage;
        this.additionalQualification = additionalQualification;
        this.childrenInformation = childrenInformation;
        this.disciplinaryActionDetails = disciplinaryActionDetails;
        this.educationalInformation = educationalInformation;
        this.firstJoiningInformation = firstJoiningInformation;
        this.foreignTrainingInformation = foreignTrainingInformation;
        this.foreignTravel = foreignTravel;
        this.honorsandaward = honorsandaward;
        this.inServiceTrainingInformation = inServiceTrainingInformation;
        this.jobEntryProcess = jobEntryProcess;
        this.languageinfo = languageinfo;
        this.leaveinfo = leaveinfo;
        this.magisterialPower = magisterialPower;
        this.membership = membership;
        this.otherServiceInformation = otherServiceInformation;
        this.postingAbroadInformation = postingAbroadInformation;
        this.postingRecordInformation = postingRecordInformation;
        this.acr = acr;
        this.presentJob = presentJob;
        this.promotionsInformation = promotionsInformation;
        this.publicationInformation = publicationInformation;
        this.retirementPension = retirementPension;
        this.selectionGrade = selectionGrade;
        this.spousName = spousName;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogOut() {
        return lastLogOut;
    }

    public void setLastLogOut(Date lastLogOut) {
        this.lastLogOut = lastLogOut;
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

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public List<AdditionalQualification> getAdditionalQualification() {
        return additionalQualification;
    }

    public void setAdditionalQualification(List<AdditionalQualification> additionalQualification) {
        this.additionalQualification = additionalQualification;
    }

    public List<AddressInformation> getAddressInformation() {
        return addressInformation;
    }

    public void setAddressInformation(List<AddressInformation> addressInformation) {
        this.addressInformation = addressInformation;
    }

    public List<ChildrenInformation> getChildrenInformation() {
        return childrenInformation;
    }

    public void setChildrenInformation(List<ChildrenInformation> childrenInformation) {
        this.childrenInformation = childrenInformation;
    }

    public List<DisciplinaryActionDetails> getDisciplinaryActionDetails() {
        return disciplinaryActionDetails;
    }

    public void setDisciplinaryActionDetails(List<DisciplinaryActionDetails> disciplinaryActionDetails) {
        this.disciplinaryActionDetails = disciplinaryActionDetails;
    }

    public List<EducationalInformation> getEducationalInformation() {
        return educationalInformation;
    }

    public void setEducationalInformation(List<EducationalInformation> educationalInformation) {
        this.educationalInformation = educationalInformation;
    }

    public FirstJoiningInformation getFirstJoiningInformation() {
        return firstJoiningInformation;
    }

    public void setFirstJoiningInformation(FirstJoiningInformation firstJoiningInformation) {
        this.firstJoiningInformation = firstJoiningInformation;
    }

    public List<ForeignTrainingInformation> getForeignTrainingInformation() {
        return foreignTrainingInformation;
    }

    public void setForeignTrainingInformation(List<ForeignTrainingInformation> foreignTrainingInformation) {
        this.foreignTrainingInformation = foreignTrainingInformation;
    }

    public List<ForeignTravel> getForeignTravel() {
        return foreignTravel;
    }

    public void setForeignTravel(List<ForeignTravel> foreignTravel) {
        this.foreignTravel = foreignTravel;
    }

    public List<HonorsAndAwardInformation> getHonorsandaward() {
        return honorsandaward;
    }

    public void setHonorsandaward(List<HonorsAndAwardInformation> honorsandaward) {
        this.honorsandaward = honorsandaward;
    }

    public List<InServiceTrainingInformation> getInServiceTrainingInformation() {
        return inServiceTrainingInformation;
    }

    public void setInServiceTrainingInformation(List<InServiceTrainingInformation> inServiceTrainingInformation) {
        this.inServiceTrainingInformation = inServiceTrainingInformation;
    }

    public JobEntryProcess getJobEntryProcess() {
        return jobEntryProcess;
    }

    public void setJobEntryProcess(JobEntryProcess jobEntryProcess) {
        this.jobEntryProcess = jobEntryProcess;
    }

    public List<LanguageInformation> getLanguageinfo() {
        return languageinfo;
    }

    public void setLanguageinfo(List<LanguageInformation> languageinfo) {
        this.languageinfo = languageinfo;
    }

    public List<Leaveinfo> getLeaveinfo() {
        return leaveinfo;
    }

    public void setLeaveinfo(List<Leaveinfo> leaveinfo) {
        this.leaveinfo = leaveinfo;
    }

    public List<MagisterialPower> getMagisterialPower() {
        return magisterialPower;
    }

    public void setMagisterialPower(List<MagisterialPower> magisterialPower) {
        this.magisterialPower = magisterialPower;
    }

    public List<Membership> getMembership() {
        return membership;
    }

    public void setMembership(List<Membership> membership) {
        this.membership = membership;
    }

    public List<OtherServiceInformation> getOtherServiceInformation() {
        return otherServiceInformation;
    }

    public void setOtherServiceInformation(List<OtherServiceInformation> otherServiceInformation) {
        this.otherServiceInformation = otherServiceInformation;
    }

    public List<PostingAbroadInformation> getPostingAbroadInformation() {
        return postingAbroadInformation;
    }

    public void setPostingAbroadInformation(List<PostingAbroadInformation> postingAbroadInformation) {
        this.postingAbroadInformation = postingAbroadInformation;
    }

    public List<PostingRecordInformation> getPostingRecordInformation() {
        return postingRecordInformation;
    }

    public void setPostingRecordInformation(List<PostingRecordInformation> postingRecordInformation) {
        this.postingRecordInformation = postingRecordInformation;
    }

    public List<Acr> getAcr() {
        return acr;
    }

    public void setAcr(List<Acr> acr) {
        this.acr = acr;
    }

    public PresentJob getPresentJob() {
        return presentJob;
    }

    public void setPresentJob(PresentJob presentJob) {
        this.presentJob = presentJob;
    }

    public List<PromotionsInformation> getPromotionsInformation() {
        return promotionsInformation;
    }

    public void setPromotionsInformation(List<PromotionsInformation> promotionsInformation) {
        this.promotionsInformation = promotionsInformation;
    }

    public List<PublicationInformation> getPublicationInformation() {
        return publicationInformation;
    }

    public void setPublicationInformation(List<PublicationInformation> publicationInformation) {
        this.publicationInformation = publicationInformation;
    }

    public RetirementPension getRetirementPension() {
        return retirementPension;
    }

    public void setRetirementPension(RetirementPension retirementPension) {
        this.retirementPension = retirementPension;
    }

    public List<SelectionGrade> getSelectionGrade() {
        return selectionGrade;
    }

    public void setSelectionGrade(List<SelectionGrade> selectionGrade) {
        this.selectionGrade = selectionGrade;
    }

    public List<SpousName> getSpousName() {
        return spousName;
    }

    public void setSpousName(List<SpousName> spousName) {
        this.spousName = spousName;
    }

}
