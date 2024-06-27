/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package itgarden.report.services;

import itgarden.model.*;
import itgarden.reportDTO.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class PromotionsService {

    @PersistenceContext
    EntityManager em;

    public List<PromotionReportDTO> lastPromotions() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);

        Root<PromotionsInformation> root = cq.from(PromotionsInformation.class);

        Expression<Date> dates = cb.greatest(root.<Date>get("dateofPromotion"));

        Expression<Number> yearno = cb.diff(
                cb.function("YEAR", Integer.class, cb.currentDate()),
                cb.function("YEAR", Integer.class, dates));

        cq.multiselect(
                root.get("governmentId").get("governmentId").alias("gid"),
                root.get("governmentId").get("name").alias("name"),
                dates.alias("datess"),
                yearno.alias("yearno")
        );

        cq.groupBy(root.get("governmentId").get("governmentId"));

        ///cq.having();
        //  cq.orderBy(cb.asc(dates));
        TypedQuery<Tuple> result = em.createQuery(cq);

        List<PromotionReportDTO> lastPromorList = new ArrayList<>();

        for (Tuple results : result.getResultList()) {

            PromotionReportDTO lastPromor = new PromotionReportDTO();

            lastPromor.setGid(results.get("gid", String.class));

            lastPromor.setName(results.get("name", String.class));

            lastPromor.setLastPromotionDate(results.get("datess", Date.class));

            lastPromor.setYearAgo(results.get("yearno", Integer.class).toString());

            lastPromorList.add(lastPromor);
        }

        return lastPromorList;
    }

}
