/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itgarden.service;

import itgarden.model.*;
import itgarden.model.enumvalue.*;
import itgarden.model.lookup.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Admin
 */
@Service
public class UsersServices {

    @PersistenceContext
    EntityManager em;

    public Users findByGovernmentIdAndStatus(String governmentId, Status status) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        Root<Users> root = cq.from(Users.class);
        cq.multiselect(
                root.get("id").alias("id"),
                root.get("name").alias("name"),
                root.get("governmentId").alias("governmentId"),
                root.get("email").alias("email"),
                root.get("password").alias("password"),
                root.get("role").alias("role"),
                root.get("status").alias("status")
        );

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.and(cb.like(root.get("governmentId"), governmentId)));

        predicates.add(cb.and(cb.equal(root.get("status"), status)));

        cq.where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Tuple> result = em.createQuery(cq);
        Tuple results = result.getSingleResult();      
        Users users = new Users();
        users.setId(results.get("id", Long.class));
        users.setName(results.get("name", String.class));
        users.setGovernmentId(results.get("governmentId", String.class));
        users.setEmail(results.get("email", String.class));
        users.setPassword(results.get("password", String.class));
        users.setRole((Set<Role>) results.get("role", Role.class));
        users.setStatus(results.get("status", Status.class));
        return users;
    }

}
