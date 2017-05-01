package com.trinityinnovations.MoCoData;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
@Service("histogramService")
public class HistogramService {

  @Autowired
  private HistogramDao histogramDao;

  @Transactional
  public List<HistogramWrapper> getHistogram(String start_date, String end_date, String city) {
    return histogramDao.getHistogram(start_date, end_date, city);
  }
}
