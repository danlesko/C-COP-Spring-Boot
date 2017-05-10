// This is the service that interacts with the rest API
// Created by Dan Lesko, Rachel Newkirk, and Josh Sharo

import { Injectable } from '@angular/core';
import { Http }       from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class DataFetchService {

  constructor(private http: Http) { }

  // no longer used as they access the MoCo DB directly
  fetchCrime(): Observable<any> {
    let url = "https://data.montgomerycountymd.gov/resource/yc8a-5df8.json?$limit=80";
    return this.http
      .get(url)
      .map(response => response.json() as any);
  }

  // no longer used as they access the MoCo DB directly
  fetchArrests(): Observable<any> {
    let url = "https://data.montgomerycountymd.gov/resource/mavv-8s3f.json?$limit=20";
    return this.http
      .get(url)
      .map(response => response.json() as any);
  }

  // URLs to hit our own custom rest API's
  private crimeURL = './CrimeData';
  private arrestsURL = './ArrestsData';
  private histogramURL = './Histogram';
  private pieURL = './Pie';

  // Below are all the rest API's that are used in our application, the function name should describe what they do effectively
  getArrestsInInterval(start_date, end_date, city_filter): Observable<any>{
    let url = `${this.arrestsURL}/${start_date}/${end_date}/${city_filter}`;
    return this.http
      .get(url)
      .map(response=> response.json() as any);
  }

  getCrimesInInterval(start_date, end_date, city_filter): Observable<any>{
    let url = `${this.crimeURL}/${start_date}/${end_date}/${city_filter}`;
    return this.http
      .get(url)
      .map(response=> response.json() as any);
  }

  getHistogram(start_date, end_date, city): Observable<any>{
    let url = `${this.histogramURL}/${start_date}/${end_date}/${city}`;
    return this.http
      .get(url)
      .map(response=> response.json() as any);
  }

  getCities(): Observable<any>{
    let url = `${this.crimeURL}/cities`;
    return this.http
      .get(url)
      .map(response=> response.json() as any);
  }

  getArrestPie(start_date, end_date, city_filter): Observable<any>{
    let url = `${this.pieURL}/Arrest/${start_date}/${end_date}/${city_filter}`;
    return this.http
        .get(url)
        .map(response=> response.json() as any);
  }

  getCrimePie(start_date, end_date, city_filter): Observable<any>{
    let url = `${this.pieURL}/Crime/${start_date}/${end_date}/${city_filter}`;
    return this.http
        .get(url)
        .map(response=> response.json() as any);
  }
}
