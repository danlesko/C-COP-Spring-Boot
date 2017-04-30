import { Injectable } from '@angular/core';
import { Http }       from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class DataFetchService {

  constructor(private http: Http) { }

  fetchCrime(): Observable<any> {
    let url = "https://data.montgomerycountymd.gov/resource/yc8a-5df8.json?$limit=80";
    return this.http
      .get(url)
      .map(response => response.json() as any);
  }

  fetchArrests(): Observable<any> {
    let url = "https://data.montgomerycountymd.gov/resource/mavv-8s3f.json?$limit=20";
    return this.http
      .get(url)
      .map(response => response.json() as any);
  }

  private crimeURL = './CrimeData';
  private arrestsURL = './ArrestsData';
  private histogramURL = './Histogram';

  getArrestsInInterval(start_date, end_date, city_filter): Observable<any>{
    let url = `${this.arrestsURL}/${start_date}/${end_date}`;
    return this.http
      .get(url)
      .map(response=> response.json() as any);
  }

  getCrimesInInterval(start_date, end_date, city_filter): Observable<any>{
    let url = `${this.crimeURL}/${start_date}/${end_date}`;
    return this.http
      .get(url)
      .map(response=> response.json() as any);
  }

  getHistogram(start_date, end_date): Observable<any>{
    let url = `${this.histogramURL}/${start_date}/${end_date}`;
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

  // getCrimesHistogram(start_date, end_date): Observable<any>{
  //   let url = `${this.crimeURL}/histogram/${start_date}/${end_date}`;
  //   return this.http
  //     .get(url)
  //     .map(response=> response.json() as any);
  // }
}
