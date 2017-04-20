package com.trinityinnovations.MoCoData;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by Dan Lesko on 4/9/2017.
 */
@Entity
@IdClass(Arrests.class)
@Table(name = "arrest")
public class Arrests implements Serializable {

  @Id
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

  @Id
  @Column(name = "arrest_date")
  private String arrest_date;

  @Column(name = "offense")
  private String offense;

  @Column(name = "latitude")
  private double latitude;

  @Column(name = "longitude")
  private double longitude;

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

  public String getArrest_date() {
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

}
