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
@RequestMapping("/Histogram")
public class HistogramController {

  @Resource(name = "histogramService")
  private HistogramService histogramService;

  @GetMapping(path = "/{start_date}/{end_date}", produces = "application/json")
  @ResponseBody
  public List<HistogramWrapper> getHistogram(@PathVariable String start_date, @PathVariable String end_date) {
    return histogramService.getHistogram(start_date, end_date);
  }
}
