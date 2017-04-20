package com.trinityinnovations.MoCoData;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
@Repository
public class CrimeDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Crime> getCrimesInInterval(String start_date, String end_date) {
        List<Crime> crimes;
        crimes = entityManager.createNativeQuery(
                "SELECT * " + "FROM crime WHERE date BETWEEN \'" + start_date + "\' AND \'"
                        + end_date + "\'" + "ORDER BY date DESC", Crime.class).getResultList();
        crimes.removeIf(Objects::isNull);
        return crimes;
    }
}
