package com.trinityinnovations.MoCoData;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * Created by Dan Lesko on 4/9/2017.
 * mySQL statement created by Joshua Sharo
 */
@Repository
public class HistogramDao {

  private EntityManager entityManager;

  @PersistenceContext
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }


  public List<HistogramWrapper> getHistogram(String start_date, String end_date, String thecity) {
    List<HistogramWrapper> histogramData;

    String queryString = "";

    if (thecity.toUpperCase().equals("NONE")) {
      queryString = "  SELECT COALESCE(t1.tmstamp, 0) as dateBucket, COALESCE(t1.cnt,0) as arrestCount, COALESCE(t2.cnt, 0) as crimeCount\n" +
        "  from\n" +
        "  (SELECT DATE_FORMAT(MIN(arrest_date), '%Y/%m/%d') AS tmstamp,\n" +
        "  COUNT(*) AS cnt\n" +
        "  FROM arrest\n" +
        "  WHERE arrest_date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\'\n " +
        "  GROUP BY ROUND(UNIX_TIMESTAMP(arrest_date) / 86400)) t1\n" +
        "  LEFT JOIN\n" +
        "  (SELECT DATE_FORMAT(MIN(date), '%Y/%m/%d') AS tmstamp,\n" +
        "  COUNT(*) AS cnt\n" +
        "  FROM crime\n" +
        "  WHERE date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\'\n " +
        "  GROUP BY ROUND(UNIX_TIMESTAMP(date) / 86400)) t2\n" +
        "  ON t1.tmstamp = t2.tmstamp";
    } else {
      queryString = "  SELECT COALESCE(t1.tmstamp, 0) as dateBucket, COALESCE(t1.cnt,0) as arrestCount, COALESCE(t2.cnt, 0) as crimeCount\n" +
        "  from\n" +
        "  (SELECT DATE_FORMAT(MIN(arrest_date), '%Y/%m/%d') AS tmstamp,\n" +
        "  COUNT(*) AS cnt\n" +
        "  FROM arrest\n" +
        "  WHERE city = \'" + thecity.toUpperCase() + "\' AND arrest_date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\'\n " +
        "  GROUP BY ROUND(UNIX_TIMESTAMP(arrest_date) / 86400)) t1\n" +
        "  LEFT JOIN\n" +
        "  (SELECT DATE_FORMAT(MIN(date), '%Y/%m/%d') AS tmstamp,\n" +
        "  COUNT(*) AS cnt\n" +
        "  FROM crime\n" +
        "  WHERE city = \'" + thecity.toUpperCase() + "\' AND date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\'\n " +
        "  GROUP BY ROUND(UNIX_TIMESTAMP(date) / 86400)) t2\n" +
        "  ON t1.tmstamp = t2.tmstamp";
    }

    histogramData = entityManager.createNativeQuery(queryString).getResultList();

    return histogramData;
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
