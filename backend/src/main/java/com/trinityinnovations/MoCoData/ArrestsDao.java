package com.trinityinnovations.MoCoData;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.javaetmoi.core.persistence.hibernate.JpaLazyLoadingUtil;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
@Repository
public class ArrestsDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Arrests> getArrestsInInterval(String start_date, String end_date) {

        List<Arrests> arrests;
        arrests = entityManager.createNativeQuery(
                "SELECT * " + "FROM arrest WHERE arrest_date BETWEEN \'" + start_date + "\' AND \'"
                        + end_date + "\'" + "ORDER BY arrest_date DESC", Arrests.class).getResultList();
        return arrests;
    }
}
