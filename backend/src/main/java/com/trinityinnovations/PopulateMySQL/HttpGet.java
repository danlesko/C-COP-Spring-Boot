package com.trinityinnovations.PopulateMySQL;

import java.io.IOException;
import java.sql.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * Created by Rob on 4/2/17.
 */
public class HttpGet {

/*
 * $HeadURL$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 * [Additional notices, if required by prior licensing conditions]
 *
 */


    /**
     * This is a simple text mode application that demonstrates
     * how to use the Jakarta HttpClient API.
     *
     * @author <a href="mailto:jsdever@apache.org">Jeff Dever</a>
     * @author Ortwin Glück
     */


    private static final void printUsage() {
        System.out.println();
        System.out.println("Usage: java -classpath <classpath> [-Dorg.apache.commons.logging.simplelog.defaultlog=<loglevel>] TrivialApp <url> [<username> <password>]");
        System.out.println("<classpath> - must contain the commons-httpclient.jar and commons-logging.jar");
        System.out.println("<loglevel> - one of error, warn, info, debug, trace");
        System.out.println("<url> - some valid URL");
        System.out.println("<username> - username for protected page");
        System.out.println("<password> - password for protected page");
        System.out.println();
    }

    public static String query(String url) {
        //create a singular HttpClient object
        HttpClient client = new HttpClient();

        //establish a connection within 5 seconds
        client.getHttpConnectionManager().
                getParams().setConnectionTimeout(5000);

        HttpMethod method = null;

        //create a method object
        method = new GetMethod(url);
        method.setFollowRedirects(false);
        //} catch (MalformedURLException murle) {
        //    System.out.println("<url> argument '" + url
        //            + "' is not a valid URL");
        //    System.exit(-2);
        //}

        method.setRequestHeader("X-App-Token", "4212eAK21nPoYcV7DN22LKbcH");
//        method.setRequestHeader("limit", "200000");
        //execute the method
        String responseBody = null;
        try {
            client.executeMethod(method);
            responseBody = method.getResponseBodyAsString();
        } catch (HttpException he) {
            System.err.println("Http error connecting to '" + url + "'");
            System.err.println(he.getMessage());
            System.exit(-4);
        } catch (IOException ioe) {
            System.err.println("Unable to connect to '" + url + "'");
            System.exit(-3);
        }


        //write out the request headers
        System.out.println("*** Request ***");
        System.out.println("Request Path: " + method.getPath());
        System.out.println("Request Query: " + method.getQueryString());
        Header[] requestHeaders = method.getRequestHeaders();
        for (int i = 0; i < requestHeaders.length; i++) {
            System.out.print(requestHeaders[i]);
        }

        //write out the response headers
        System.out.println("*** Response ***");
        System.out.println("Status Line: " + method.getStatusLine());
        Header[] responseHeaders = method.getResponseHeaders();
        for (int i = 0; i < responseHeaders.length; i++) {
            System.out.print(responseHeaders[i]);
        }

        //write out the response body
        System.out.println("*** Response Body ***");
        System.out.println(responseBody);

        //clean up the connection resources
        method.releaseConnection();

        return responseBody;
    }

    public static void main(String[] args) {
        // Convert from String to Java Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

        // Holds the data received from the query
        String responseBody;

        responseBody = query("https://data.montgomerycountymd.gov/resource/yc8a-5df8.csv?$limit=200000");

        class CrimeEntry {
            String incident_id;
            String case_number;
            String date;
            String incident_type;
            String narrative;
            String district;
            String location;
            String city;
            String state;
            int zip_code;
            String agency;
            String place;
            String sector;
            String beat;
            String pra;
            String start_date;
            String end_date;
            String police_district_number;
            String geolocation_city;
            double latitude;
            double longitude;
            String geolocation_address;
            String address_number;
            String geolocation_zip;
            String geolocation_state;

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

            public Timestamp getDate() {
                Timestamp myDate = new Timestamp(sdf.parse(date, new ParsePosition(0)).getTime());
                return myDate;
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

            public Timestamp getStart_date() {
                Timestamp myDate = new Timestamp(sdf.parse(start_date, new ParsePosition(0)).getTime());
                return myDate;
            }

            public void setStart_date(String start_date) {
                if (start_date.length() > 0) {
                    this.start_date = start_date;
                }
            }

            public Timestamp getEnd_date() {
                if (end_date == null) {
                    return null;
                }
                Timestamp myDate = new Timestamp(sdf.parse(end_date, new ParsePosition(0)).getTime());
                return myDate;
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

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Connect to the database
            // Generally database runs on port 3306
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CCOP?" + "user=root&password=password&serverTimezone=US/Eastern");

            // SQL to talk to database
            String sql = "insert into crime (incident_id, case_number, date, incident_type, narrative," +
                    "district, location, city, state, zip_code, agency, place, sector, beat," +
                    "pra, start_date, end_date, police_district_number, geolocation_city, latitude," +
                    "longitude, geolocation_address, address_number, geolocation_zip, geolocation_state)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Allows you to use the SQL
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            CSVParser parser = CSVParser.parse(responseBody, CSVFormat.EXCEL);
            CrimeEntry entry = new CrimeEntry();
            boolean firstEntry = true;
            for (CSVRecord csvRecord : parser) {
                if (!firstEntry) {
                    Iterator<String> iterator = csvRecord.iterator();
                    if (csvRecord.size() > 24) {
                        for (int i = 0; i < 4; i++) {
                            iterator.next(); // Overlook computed regions (checksums)
                        }
                    }

                    entry.setAddress_number(iterator.next());
                    entry.setAgency(iterator.next());
                    entry.setBeat(iterator.next());
                    entry.setCase_number(iterator.next());
                    entry.setCity(iterator.next());
                    entry.setDate(iterator.next());
                    entry.setDistrict(iterator.next());
                    entry.setEnd_date(iterator.next());
                    entry.setPoint(iterator.next());
                    entry.setGeolocation_address(iterator.next());
                    entry.setGeolocation_city(iterator.next());
                    entry.setGeolocation_state(iterator.next());
                    entry.setGeolocation_zip(iterator.next());
                    entry.setIncident_id(iterator.next());
                    entry.setIncident_type(iterator.next());
                    entry.setLocation(iterator.next());
                    entry.setNarrative(iterator.next());
                    entry.setPlace(iterator.next());
                    entry.setPolice_district_number(iterator.next());
                    entry.setPra(iterator.next());
                    entry.setSector(iterator.next());
                    entry.setStart_date(iterator.next());
                    entry.setState(iterator.next());
                    entry.setZip_code(iterator.next());

                    try {
                        int param = 1;
                        pstmt.setString(param++, entry.getIncident_id());
                        pstmt.setString(param++, entry.getCase_number());
                        pstmt.setTimestamp(param++, entry.getDate());
                        pstmt.setString(param++, entry.getIncident_type());
                        pstmt.setString(param++, entry.getNarrative());
                        pstmt.setString(param++, entry.getDistrict());
                        pstmt.setString(param++, entry.getLocation());
                        pstmt.setString(param++, entry.getCity());
                        pstmt.setString(param++, entry.getState());
                        pstmt.setInt(param++, entry.getZip_code());
                        pstmt.setString(param++, entry.getAgency());
                        pstmt.setString(param++, entry.getPlace());
                        pstmt.setString(param++, entry.getSector());
                        pstmt.setString(param++, entry.getBeat());
                        pstmt.setString(param++, entry.getPra());
                        pstmt.setTimestamp(param++, entry.getStart_date());
                        pstmt.setTimestamp(param++, entry.getEnd_date());
                        pstmt.setString(param++, entry.getPolice_district_number());
                        pstmt.setString(param++, entry.getGeolocation_city());
                        pstmt.setDouble(param++, entry.getLatitude());
                        pstmt.setDouble(param++, entry.getLongitude());
                        pstmt.setString(param++, entry.getGeolocation_address());
                        pstmt.setString(param++, entry.getAddress_number());
                        pstmt.setString(param++, entry.getGeolocation_zip());
                        pstmt.setString(param++, entry.getGeolocation_state());

                        pstmt.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
                firstEntry = false;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        class ArrestEntry {
            String last_name;
            String first_name;
            String middle_name;
            int age;
            String street;
            String city;
            String state;
            String arrest_date;
            String offense;

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

            public Timestamp getArrest_date() {
                Timestamp myDate = new Timestamp(sdf.parse(arrest_date, new ParsePosition(0)).getTime());
                return myDate;
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
        }

        responseBody = query("https://data.montgomerycountymd.gov/resource/mavv-8s3f.csv?$limit=10000");

        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost/CCOP?" + "user=root&password=password&serverTimezone=US/Eastern");

            // SQL to talk to database
            String sql = "insert into arrest (last_name, first_name, middle_name, age, street, city, state, arrest_date, offense)" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Allows you to use the SQL
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        try {
            CSVParser parser = CSVParser.parse(responseBody, CSVFormat.EXCEL);
            ArrestEntry entry = new ArrestEntry();
            boolean firstEntry = true;
            for (CSVRecord csvRecord : parser) {
                if (!firstEntry) {
                    Iterator<String> iterator = csvRecord.iterator();
                    if (csvRecord.size() > 9) {
                        for (int i = 0; i < 4; i++) {
                            iterator.next(); // Overlook computed regions (checksums)
                        }
                    }
                    entry.setAge(iterator.next());
                    entry.setArrest_date(iterator.next());
                    entry.setCity(iterator.next());
                    entry.setFirst_name(iterator.next());
                    entry.setLast_name(iterator.next());
                    entry.setMiddle_name(iterator.next());
                    entry.setOffense(iterator.next());
                    entry.setState(iterator.next());
                    entry.setStreet(iterator.next());

                    try {
                        int param = 1;
                        pstmt.setString(param++, entry.getLast_name());
                        pstmt.setString(param++, entry.getFirst_name());
                        pstmt.setString(param++, entry.getMiddle_name());
                        pstmt.setInt(param++, entry.getAge());
                        pstmt.setString(param++, entry.getStreet());
                        pstmt.setString(param++, entry.getCity());
                        pstmt.setString(param++, entry.getState());
                        pstmt.setTimestamp(param++, entry.getArrest_date());
                        pstmt.setString(param++, entry.getOffense());
                        pstmt.executeUpdate();
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
                firstEntry = false;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        System.exit(0);
    }
}