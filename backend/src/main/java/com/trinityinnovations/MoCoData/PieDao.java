package com.trinityinnovations.MoCoData;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Dan Lesko on 4/9/2017.
 */

// Class to access the database itself and make queries for Pie chart
@Repository
public class PieDao {

  private EntityManager entityManager;

  @PersistenceContext
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }


  public List<PieWrapper> getArrestPie(String start_date, String end_date, String thecity) {
    List<PieWrapper> pieData;

    String queryString = "";

    if (thecity.toUpperCase().equals("NONE")) {
      queryString = "SELECT offense as description, COUNT(*) as count \n" +
        "FROM `arrest` \n" +
        "WHERE offense is not null \n" +
        "AND arrest_date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\' \n" +
        "GROUP BY offense";
    } else {
      queryString = "SELECT offense as description, COUNT(*) as count \n" +
        "FROM `arrest` \n" +
        "WHERE offense is not null \n" +
        "AND city = \'" + thecity.toUpperCase() + "\' \n" +
        "AND arrest_date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\' \n" +
        "GROUP BY offense";
    }

    pieData = entityManager.createNativeQuery(queryString).getResultList();

    return pieData;
  }

  public List<PieWrapper> getCrimePie(String start_date, String end_date, String thecity) {
    List<PieWrapper> pieData;

    String queryString = "";

    if (thecity.toUpperCase().equals("NONE")) {
      queryString = "SELECT narrative as description, COUNT(*) as count \n" +
        "FROM `crime` \n" +
        "WHERE narrative is not null \n" +
        "AND date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\' \n" +
        "GROUP BY narrative";
    } else {
      queryString = "SELECT narrative as description, COUNT(*) as count \n" +
        "FROM `crime` \n" +
        "WHERE narrative is not null \n" +
        "AND city = \'" + thecity.toUpperCase() + "\' \n" +
        "AND date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\' \n" +
        "GROUP BY narrative";
    }

    pieData = entityManager.createNativeQuery(queryString).getResultList();

    return pieData;
  }
}
//  SELECT COALESCE(t1.tmstamp, 0) as dateBucket, COALESCE(t1.cnt,0) as arrestCount, COALESCE(t2.cnt, 0) as crimeCount
//  from
//  (SELECT DATE_FORMAT(MIN(arrest_date), '%Y/%m/%d') AS tmstamp,
//  COUNT(*) AS cnt
//  FROM arrest
//  WHERE arrest_date BETWEEN "2017-04-02 12:40:00" AND "2017-04-24 12:40:00"
//  GROUP BY ROUND(UNIX_TIMESTAMP(arrest_date) / 86400)) t1
//  LEFT JOIN
//  (SELECT DATE_FORMAT(MIN(date), '%Y/%m/%d') AS tmstamp,
//  COUNT(*) AS cnt
//  FROM crime
//  WHERE date BETWEEN "2017-04-02 12:40:00" AND "2017-04-24 12:40:00"
//  GROUP BY ROUND(UNIX_TIMESTAMP(date) / 86400)) t2
//  ON t1.tmstamp = t2.tmstamp


  /*queryString = "SELECT narrative as description, COUNT(*) as count \n" +
  "FROM `crime` \n" +
  "WHERE narrative is not null \n" +
  "AND city = 'Silver Spring'\n" +
  "AND date BETWEEN \"2017-04-02 12:40:00\" AND \"2017-04-24 12:40:00\"\n" +
  "GROUP BY narrative";*/
