package com.trinityinnovations.MoCoData;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
@Controller
@RequestMapping("/CrimeData")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    @GetMapping(path = "/{start_date}/{end_date}", produces = "application/json")
    @ResponseBody
    public List<Crime> getCrimesInInterval(@PathVariable String start_date, @PathVariable String end_date) {
        return crimeService.getCrimesInInterval(start_date, end_date);
    }
}
