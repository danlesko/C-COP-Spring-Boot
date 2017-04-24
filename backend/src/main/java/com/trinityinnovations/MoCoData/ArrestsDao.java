package com.trinityinnovations.MoCoData;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

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
    arrests.removeIf(Objects::isNull);
    return arrests;
  }
}

//  SELECT
//  DATE_FORMAT(
//    MIN(arrest_date),
//    '%Y/%m/%d'
//      ) AS tmstamp,
//      COUNT(*) AS cnt
//      FROM
//      arrest
//      WHERE arrest_date BETWEEN "2017-04-02 12:40:00" AND "2017-04-10 12:40:00"
//      GROUP BY ROUND(UNIX_TIMESTAMP(arrest_date) / 86400)
