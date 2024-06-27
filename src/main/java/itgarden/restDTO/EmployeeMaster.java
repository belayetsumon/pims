/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.restDTO;

/**
 *
 * @author User
 */
public class EmployeeMaster {

    private String employeeID;

    private String departmant;

    private String desiggnation;

    private String postingType;
    
    private String curentGrade;
    
    private String gradeBasicSalary;
    
    private String serviceStatus;
    
    private String dateOfBirth;
    
    private String gender;

    public EmployeeMaster() {
    }

    public EmployeeMaster(String employeeID, String departmant, String desiggnation, String postingType, String curentGrade, String gradeBasicSalary, String serviceStatus, String dateOfBirth, String gender) {
        this.employeeID = employeeID;
        this.departmant = departmant;
        this.desiggnation = desiggnation;
        this.postingType = postingType;
        this.curentGrade = curentGrade;
        this.gradeBasicSalary = gradeBasicSalary;
        this.serviceStatus = serviceStatus;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }

    public String getDesiggnation() {
        return desiggnation;
    }

    public void setDesiggnation(String desiggnation) {
        this.desiggnation = desiggnation;
    }

    public String getPostingType() {
        return postingType;
    }

    public void setPostingType(String postingType) {
        this.postingType = postingType;
    }

    public String getCurentGrade() {
        return curentGrade;
    }

    public void setCurentGrade(String curentGrade) {
        this.curentGrade = curentGrade;
    }

    public String getGradeBasicSalary() {
        return gradeBasicSalary;
    }

    public void setGradeBasicSalary(String gradeBasicSalary) {
        this.gradeBasicSalary = gradeBasicSalary;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
