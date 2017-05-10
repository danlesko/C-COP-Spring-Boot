package com.trinityinnovations.MoCoData;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
@Controller
@RequestMapping("/Pie")
public class PieController {

  @Resource(name = "pieService")
  private PieService pieService;

  // GET HTTP rest API to get both crime and arrest data for pie charts

  @GetMapping(path = "/Arrest/{start_date}/{end_date}/{city}", produces = "application/json")
  @ResponseBody
  public List<PieWrapper> getArrestPie(@PathVariable String start_date, @PathVariable String end_date, @PathVariable String city) {
    return pieService.getArrestPie(start_date, end_date, city);
  }

  @GetMapping(path = "/Crime/{start_date}/{end_date}/{city}", produces = "application/json")
  @ResponseBody
  public List<PieWrapper> getCrimePie(@PathVariable String start_date, @PathVariable String end_date, @PathVariable String city) {
    return pieService.getCrimePie(start_date, end_date, city);
  }
}
