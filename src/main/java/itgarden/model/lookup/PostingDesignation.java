/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model.lookup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import itgarden.model.PresentJob;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
@Table(name = "l_posting_designation")
public class PostingDesignation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "This field cannot be blank.")
    public String name;
    
    public int orderId;

    @Lob
    public String jobDescription;

    @Lob
    public String requiredTraining;

    @Lob
    public String employeeBenefits;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "postingDesignation")
    @JsonIgnore
    public List<PresentJob> presentjob;

    public PostingDesignation() {
    }

    public PostingDesignation(Long id, String name, int orderId, String jobDescription, String requiredTraining, String employeeBenefits, List<PresentJob> presentjob) {
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.jobDescription = jobDescription;
        this.requiredTraining = requiredTraining;
        this.employeeBenefits = employeeBenefits;
        this.presentjob = presentjob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getRequiredTraining() {
        return requiredTraining;
    }

    public void setRequiredTraining(String requiredTraining) {
        this.requiredTraining = requiredTraining;
    }

    public String getEmployeeBenefits() {
        return employeeBenefits;
    }

    public void setEmployeeBenefits(String employeeBenefits) {
        this.employeeBenefits = employeeBenefits;
    }

    public List<PresentJob> getPresentjob() {
        return presentjob;
    }

    public void setPresentjob(List<PresentJob> presentjob) {
        this.presentjob = presentjob;
    }

    
}
