package com.trinityinnovations.MoCoData;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dan Lesko on 4/9/2017.
 */

// Rest API to get Crime Data
@Controller
@RequestMapping("/CrimeData")
public class CrimeController {

  @Autowired
  private CrimeService crimeService;

  // GET HTTP rest API for obtaining crime data
  @GetMapping(path = "/{start_date}/{end_date}/{city}", produces = "application/json")
  @ResponseBody
  public List<Crime> getCrimesInInterval(@PathVariable String start_date, @PathVariable String end_date, @PathVariable String city) {
    return crimeService.getCrimesInInterval(start_date, end_date, city);
  }

  // GET HTTP rest API for obtaining all cities
  @GetMapping(path = "/cities", produces = "application/json")
  @ResponseBody
  public List<String> getCities(){
      return crimeService.getCities();
  }

}
