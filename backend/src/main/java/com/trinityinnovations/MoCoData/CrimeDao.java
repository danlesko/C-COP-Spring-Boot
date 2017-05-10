package com.trinityinnovations.MoCoData;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * Created by Dan Lesko on 4/9/2017.
 */

// Class to access the database itself and make queries for Crimes
@Repository
public class CrimeDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // query that returns all Crimes within an given time interval from database with city optional
    public List<Crime> getCrimesInInterval(String start_date, String end_date, String thecity) {
        List<Crime> crimes;
        if (thecity.toUpperCase().equals("NONE")) {

          crimes = entityManager.createNativeQuery(
            "SELECT * " + "FROM crime WHERE date BETWEEN \'" + start_date + "\' AND \'"
              + end_date + "\'" + " ORDER BY date DESC", Crime.class).getResultList();
        } else {
          crimes = entityManager.createNativeQuery(
            "SELECT * " + "FROM crime WHERE city = \'" + thecity.toUpperCase() + "\' AND date BETWEEN \'" + start_date + "\' AND \'"
              + end_date + "\'" + " ORDER BY date DESC", Crime.class).getResultList();
        }
        crimes.removeIf(Objects::isNull);
        return crimes;
    }

    // query that returns all cities from crime, the only ones we care about
    public List<String> getCities(){

        List<String> city;

        city = entityManager.createNativeQuery(
          "SELECT DISTINCT city " + "FROM crime WHERE 1").getResultList();
        //city.removeIf(Objects::isNull);

      Collections.sort(city);

        return city;
    }
}
