package com.trinityinnovations.MoCoData;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Repository;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
@Repository
public class CrimeDao {

    //private static SessionFactory factory;
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

//  public List<HistogramWrapper> getCrimesHistogram(String start_date, String end_date) {
//    List<HistogramWrapper> crimes;
//
//
//    String queryString = "SELECT DATE_FORMAT(MIN(date), '%Y-%m-%d') AS datebucket, " +
//      "COUNT(*) AS count " +
//      "FROM crime WHERE date BETWEEN \'" + start_date + "\' AND \'" + end_date + "\'" +
//      "GROUP BY ROUND(UNIX_TIMESTAMP(date) / 86400)";
//
//    crimes = entityManager.createNativeQuery(queryString).getResultList();
//
//    //List<HistogramWrapper> crimes = session.createSQLQuery(queryString).list();
//    //crimes.removeIf(Objects::isNull);
//    //    session.close();
//    return crimes;
//  }
}
