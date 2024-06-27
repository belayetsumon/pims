/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package itgarden.report.services;

import itgarden.model.*;
import itgarden.restDTO.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class PlrService {

    @PersistenceContext
    EntityManager em;

    public List<PlrByYear> YearList() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        Root<GeneralInformation> root = cq.from(GeneralInformation.class);

        Expression<Integer> year = cb.function("YEAR", Integer.class, root.get("lPRDate"));

        cq.multiselect(
                year.alias("year")
        );

        cq.groupBy(year);

        cq.orderBy(cb.asc(year));

        TypedQuery<Tuple> result = em.createQuery(cq);

        List<PlrByYear> plrByYearList = new ArrayList<>();

        for (Tuple results : result.getResultList()) {

            PlrByYear plrByYear = new PlrByYear();

            plrByYear.setYear(results.get("year", Integer.class));
            plrByYearList.add(plrByYear);
        }

        return plrByYearList;
    }

    public List<PlrByYear> plrByYearList() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class
        );
        Root<GeneralInformation> root = cq.from(GeneralInformation.class
        );

        Expression<Integer> year =  cb.function("YEAR", Integer.class,
                root.get("lPRDate"));

        Expression<Long> count =  cb.count(root.get("id"));

        cq.multiselect(
                year.alias("year"),
                count.alias("total")
        );

        cq.groupBy(year);

        cq.orderBy(cb.asc(year));

        TypedQuery<Tuple> result = em.createQuery(cq);

        List<PlrByYear> plrByYearList = new ArrayList<>();

        for (Tuple results : result.getResultList()) {

            PlrByYear plrByYear = new PlrByYear();

            plrByYear.setYear(results.get("year", Integer.class));
            plrByYear.setTotal(results.get("total", Long.class));

            plrByYearList.add(plrByYear);
        }

        return plrByYearList;
    }

}
