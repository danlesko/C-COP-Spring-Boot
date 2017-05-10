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

// Rest API to get Arrest Data
@Controller
@RequestMapping("/ArrestsData")
public class ArrestsController {

    @Autowired
    private ArrestsService arrestsService;

    // GET Http method for obtaining arrest data
    @GetMapping(path = "/{start_date}/{end_date}/{city}", produces = "application/json")
    @ResponseBody
    public List<Arrests> getArrestsInInterval(@PathVariable String start_date, @PathVariable String end_date, @PathVariable String city) {
        return arrestsService.getArrestsInInterval(start_date, end_date, city);
    }
}
