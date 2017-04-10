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
@Entity
@Table(name = "crime")
public class Crime {
    @Id
    @Column(name = "incident_id", nullable = false)
    private String incident_id;

    @Column(name = "case_number")
    private String case_number;

    @Transient
    @Column(name = "date")
    private String date;

    @Column(name = "incident_type")
    private String incident_type;

    @Column(name = "narrative")
    private String narrative;

    @Column(name = "district")
    private String district;

    @Column(name = "location")
    private String location;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private int zip_code;

    @Column(name = "agency")
    private String agency;

    @Column(name = "place")
    private String place;

    @Column(name = "sector")
    private String sector;

    @Column(name = "beat")
    private String beat;

    @Column(name = "pra")
    private String pra;

    //@Transient
    @Column(name = "start_date")
    private String start_date;

    //@Transient
    @Column(name = "end_date")
    private String end_date;

    @Column(name = "police_district_number")
    private String police_district_number;

    @Column(name = "geolocation_city")
    private String geolocation_city;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "geolocation_address")
    private String geolocation_address;

    @Column(name = "address_number")
    private String address_number;

    @Column(name = "geolocation_zip")
    private String geolocation_zip;

    @Column(name = "geolocation_state")
    private String geolocation_state;

//    @Transient
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public String getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(String incident_id) {
        if (incident_id.length() > 0) {
            this.incident_id = incident_id;
        }
    }

    public String getCase_number() {
        return case_number;
    }

    public void setCase_number(String case_number) {
        if (case_number.length() > 0) {
            this.case_number = case_number;
        }
    }

    public /*Timestamp*/ String getDate() {
        //Timestamp myDate = new Timestamp(sdf.parse(date, new ParsePosition(0)).getTime());
        return date;
    }

    public void setDate(String date) {
        if (date.length() > 0) {
            this.date = date;
        }
    }

    public String getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(String incident_type) {
        if (incident_type.length() > 0) {
            this.incident_type = incident_type;
        }
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        if (narrative.length() > 0) {
            this.narrative = narrative;
        }
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        if (district.length() > 0) {
            this.district = district;
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location.length() > 0) {
            this.location = location;
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

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        if (zip_code.length() > 0) {
            this.zip_code = Integer.valueOf(zip_code);
        }
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        if (agency.length() > 0) {
            this.agency = agency;
        }
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        if (place.length() > 0) {
            this.place = place;
        }
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        if (sector.length() > 0) {
            this.sector = sector;
        }
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        if (beat.length() > 0) {
            this.beat = beat;
        }
    }

    public String getPra() {
        return pra;
    }

    public void setPra(String pra) {
        if (beat.length() > 0) {
            this.pra = pra;
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

    public String getPolice_district_number() {
        return police_district_number;
    }

    public void setPolice_district_number(String police_district_number) {
        if (police_district_number.length() > 0) {
            this.police_district_number = police_district_number;
        }
    }

    public String getGeolocation_city() {
        return geolocation_city;
    }

    public void setGeolocation_city(String geolocation_city) {
        if (geolocation_city.length() > 0) {
            this.geolocation_city = geolocation_city;
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getGeolocation_address() {
        return geolocation_address;
    }

    public void setGeolocation_address(String geolocation_address) {
        if (geolocation_address.length() > 0) {
            this.geolocation_address = geolocation_address;
        }
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        if (address_number.length() > 0) {
            this.address_number = address_number;
        }
    }

    public String getGeolocation_zip() {
        return geolocation_zip;
    }

    public void setGeolocation_zip(String geolocation_zip) {
        if (geolocation_zip.length() > 0) {
            this.geolocation_zip = geolocation_zip;
        }
    }

    public String getGeolocation_state() {
        return geolocation_state;
    }

    public void setGeolocation_state(String geolocation_state) {
        if (geolocation_state.length() > 0) {
            this.geolocation_state = geolocation_state;
        }
    }

    public void setPoint(String point) {
        if (point.length() > 8) {
            point = point.substring(7, point.length() - 1);
            String[] points = point.split(" ");
            setLatitude(Double.valueOf(points[0]));
            setLongitude(Double.valueOf(points[1]));
        }
    }
}
