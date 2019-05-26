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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Md Belayet Hossin
 */
@Entity
@Table(name="l_sub_department")
public class SubDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "This field cannot be blank.")
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Department department;

    @NotEmpty(message = "This field cannot be blank.")
    public String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "subDepartment")
    public List<Users> subDepartment = new ArrayList<>();

    public SubDepartment(Long id, Department department, String name) {
        this.id = id;
        this.department = department;
        this.name = name;
    }

    public SubDepartment() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(List<Users> subDepartment) {
        this.subDepartment = subDepartment;
    }

}
