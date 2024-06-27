/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.service;

import itgarden.model.GeneralInformation;
import itgarden.model.enumvalue.BloodGroup;
import itgarden.model.enumvalue.District;
import itgarden.model.enumvalue.EmployeeStatus;
import itgarden.model.enumvalue.EthnicIdentity;
import itgarden.model.enumvalue.Gender;
import itgarden.model.enumvalue.MaritalStatus;
import itgarden.model.enumvalue.Religion;
import itgarden.model.lookup.Department;
import itgarden.model.lookup.SubDepartment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author User
 */
@Service
public class GeneralInformationService {

    @PersistenceContext
    EntityManager em;

    public List<GeneralInformation> gInfoSearchList(
            String governmentId,
            Department department,
            SubDepartment subDepartment,
            String email,
            String mobile,
            String name,
            String nameBangla,
            District homeDistrict,
            Date dateofBirth,
            String birthCertificateNumber,
            Gender gender,
            MaritalStatus maritalStatus,
            Religion religion,
            EthnicIdentity ethnicIdentity,
            BloodGroup bloodGroup,
            String nid,
            int lpryear,
            //            Date lPRStartDate,
            //            Date lPREndDate,
            EmployeeStatus employeeStatus
    ) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<GeneralInformation> cq = cb.createQuery(GeneralInformation.class);
        Root<GeneralInformation> root = cq.from(GeneralInformation.class);
        cq.select(root);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (!StringUtils.isEmpty(governmentId)) {
            predicates.add(cb.and(cb.like(root.get("governmentId"), governmentId)));
        }

        if (!ObjectUtils.isEmpty(department)) {

            predicates.add(cb.and(cb.equal(root.get("governmentId").get("department"), department)));
        }

        if (!ObjectUtils.isEmpty(subDepartment)) {

            predicates.add(cb.and(cb.equal(root.get("governmentId").get("subDepartment"), subDepartment)));
        }

        if (!StringUtils.isEmpty(email)) {
            predicates.add(cb.and(cb.like(root.get("governmentId").get("email"), email)));
        }
        if (!StringUtils.isEmpty(mobile)) {
            predicates.add(cb.and(cb.like(root.get("governmentId").get("mobile"), mobile)));
        }
        if (!StringUtils.isEmpty(name)) {
            predicates.add(cb.and(cb.like(root.get("name"), name)));
        }

        if (!StringUtils.isEmpty(nameBangla)) {
            predicates.add(cb.and(cb.like(root.get("nameBangla"), nameBangla)));
        }

        if (!ObjectUtils.isEmpty(homeDistrict)) {

            predicates.add(cb.and(cb.equal(root.get("homeDistrict"), homeDistrict)));
        }

        if (!StringUtils.isEmpty(dateofBirth)) {
            predicates.add(cb.and(cb.equal(root.get("dateofBirth"), dateofBirth)));
        }

        if (!StringUtils.isEmpty(birthCertificateNumber)) {
            predicates.add(cb.and(cb.equal(root.get("birthCertificateNumber"), birthCertificateNumber)));
        }

        if (!ObjectUtils.isEmpty(gender)) {

            predicates.add(cb.and(cb.equal(root.get("gender"), gender)));
        }

        if (!ObjectUtils.isEmpty(maritalStatus)) {

            predicates.add(cb.and(cb.equal(root.get("maritalStatus"), maritalStatus)));
        }

        if (!ObjectUtils.isEmpty(religion)) {

            predicates.add(cb.and(cb.equal(root.get("religion"), religion)));
        }

        if (!ObjectUtils.isEmpty(ethnicIdentity)) {

            predicates.add(cb.and(cb.equal(root.get("ethnicIdentity"), ethnicIdentity)));
        }

        if (!ObjectUtils.isEmpty(ethnicIdentity)) {

            predicates.add(cb.and(cb.equal(root.get("bloodGroup"), bloodGroup)));
        }

        if (!StringUtils.isEmpty(nid)) {
            predicates.add(cb.and(cb.equal(root.get("nid"), nid)));
        }

//        if (lPRStartDate != null && lPREndDate != null) {
//
//            predicates.add(cb.and(cb.between(root.get("lPRDate"), lPRStartDate, lPREndDate)));
//        }
        if (lpryear != 0) {

            predicates.add(cb.and(cb.equal(cb.function("YEAR", Integer.class, root.get("lPRDate")), lpryear)));
        }

        if (!ObjectUtils.isEmpty(employeeStatus)) {

            predicates.add(cb.and(cb.equal(root.get("employeeStatus"), employeeStatus)));
        }

        cq.where(predicates.toArray(new Predicate[]{}));

        cq.orderBy(cb.desc(root.get("id")));

        TypedQuery<GeneralInformation> result = em.createQuery(cq);

        return result.getResultList();
    }

}
