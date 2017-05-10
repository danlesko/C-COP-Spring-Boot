package com.trinityinnovations.MoCoData;

/**
 * Created by Dan Lesko on 4/24/2017.
 */

// Wrapper class for data we want to be returned for our histogram
public class HistogramWrapper {

  HistogramWrapper(){}

  private Integer arrestCount;
  private Integer crimeCount;
  private String dateBucket;


  public String getDateBucket() {
    return dateBucket;
  }

  public void setDateBucket(String dateBucket) {
    this.dateBucket = dateBucket;
  }

  public Integer getArrestCount() {
    return arrestCount;
  }

  public void setArrestCount(Integer arrestCount) {
    this.arrestCount = arrestCount;
  }
  public Integer getCrimeCount() {
    return crimeCount;
  }

  public void setCrimeCount(Integer crimeCount) {
    this.crimeCount = crimeCount;
  }




}
