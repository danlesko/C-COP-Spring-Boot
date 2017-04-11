package com.trinityinnovations.MoCoData;

import java.io.IOException;
import java.sql.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
public class Arrests {

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "age")
    private int age;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "arrest_date")
    private String arrest_date;

    @Column(name = "offense")
    private String offense;

    @Transient
    @Column(name = "start_date")
    private String start_date;

    @Transient
    @Column(name = "end_date")
    private String end_date;

    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        if (last_name.length() > 0) {
            this.last_name = last_name;
        }
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        if (first_name.length() > 0) {
            this.first_name = first_name;
        }
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        if (middle_name.length() > 0) {
            this.middle_name = middle_name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        if (age.length() > 0) {
            this.age = Integer.valueOf(age);
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street.length() > 0) {
            this.street = street;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.length() > 0) {
            this.city = city;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state.length() > 0) {
            this.state = state;
        }
    }

    public /*Timestamp*/ String getArrest_date() {
        //Timestamp myDate = new Timestamp(sdf.parse(arrest_date, new ParsePosition(0)).getTime());
        return arrest_date;
    }

    public void setArrest_date(String arrest_date) {
        if (arrest_date.length() > 0) {
            this.arrest_date = arrest_date;
        }
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        if (offense.length() > 0) {
            this.offense = offense;
        }
    }

    public /*Timestamp*/ String getStart_date() {
        //Timestamp myDate = new Timestamp(sdf.parse(start_date, new ParsePosition(0)).getTime());
        return start_date;
    }

    public void setStart_date(String start_date) {
        if (start_date.length() > 0) {
            this.start_date = start_date;
        }
    }

    public /*Timestamp*/ String getEnd_date() {
        if (end_date == null) {
            return null;
        }
        //Timestamp myDate = new Timestamp(sdf.parse(end_date, new ParsePosition(0)).getTime());
        return end_date;
    }

    public void setEnd_date(String end_date) {
        if (end_date.length() > 0) {
            this.end_date = end_date;
        }
    }

}
