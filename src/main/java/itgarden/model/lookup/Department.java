/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.model.lookup;

import itgarden.model.Users;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="l_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "This field cannot be blank.")
    public String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "department")
    public List<Users> department = new ArrayList<>();
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "department")
    public List<SubDepartment> subDepartment = new ArrayList<>();

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Users> getDepartment() {
        return department;
    }

    public void setDepartment(List<Users> department) {
        this.department = department;
    }

    public List<SubDepartment> getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(List<SubDepartment> subDepartment) {
        this.subDepartment = subDepartment;
    }

}
