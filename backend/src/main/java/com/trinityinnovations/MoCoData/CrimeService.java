package com.trinityinnovations.MoCoData;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dan Lesko on 4/9/2017.
 */

// Service to act as intermediary between controller and dao
@Service
public class CrimeService {

  @Autowired
  private CrimeDao crimeDao;

  @Transactional
  public List<Crime> getCrimesInInterval(String start_date, String end_date, String city) {
    return crimeDao.getCrimesInInterval(start_date, end_date, city);
  }

  @Transactional
  public List<String> getCities() {
    return crimeDao.getCities();
  }

}
