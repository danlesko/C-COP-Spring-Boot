import { Component, OnInit } from '@angular/core';
import { IMyOptions, IMyDateRangeModel } from 'mydaterangepicker';
import { DataFetchService } from '../global/data-fetch/data-fetch.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  providers: [DataFetchService]
})
export class DashboardComponent implements OnInit {

  private today;
  private priorDate;
  private model: any = {
    beginDate: {year: null, month: null, day: null},
    endDate: {year: null, month: null, day: null}
  };

  constructor( private dataFetchService: DataFetchService) { }

  beginDate: any;
  cities: any;
  endDate: any;
  startTime: Date = new Date();
  endTime: Date = new Date();
  crimeData : any;
  arrestsData : any;
  //crimeHistogramData : any;
  //arrestsHistogramData : any;
  histogramData: any;

  idFilter: any;
  agencyFilter: any;
  narrativeFilter: any;
  placeFilter: any;


  firstNameFilter: any;
  lastNameFilter: any;
  offenseFilter: any;

  cityFilter: any;

  ngOnInit() {
    var today = new Date()

    // Default time span is 2 weeks
    var priorDateStr = new Date().setDate(today.getDate()-14)
    this.today = today;
    var priorDate = new Date(priorDateStr);
    this.priorDate = priorDate;

    this.model = {
      beginDate: {year: this.priorDate.getFullYear(), month: this.priorDate.getMonth()+1, day: this.priorDate.getDate()},
      endDate: {year: this.today.getFullYear(), month: this.today.getMonth()+1, day:this.today.getDate()}
      };

      // console.log(this.model.endDate.day);

    this.applyGlobalFilters();
  }

  applyGlobalFilters(): void{

    console.log("Is this firing?");

    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day;

    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day;

    var start = new Date(start_date);
    var end = new Date(end_date);

    console.log(start);
    console.log(end);

    var diff = Math.abs(start.getTime() - end.getTime());

    var diffDays = Math.ceil(diff / (1000 * 3600 * 24));

    console.log("Diff days: " + diffDays);

    console.log("City Filter: " + this.cityFilter);

    if(this.cityFilter == null || this.cityFilter == '' || this.cityFilter == undefined){
      this.cityFilter = "NONE";
    }

    if (diffDays <= 30) {
      this.getArrestsInInterval();
      this.getCrimesInInterval();

      this.getHistogram();

      this.getCities();
      //this.getArrestsHistogram();
    } else {
      alert("You must pick an interval within 30 days or less!")
    }
  }

  private myDateRangePickerOptions: IMyOptions = {
    dateFormat: 'yyyy-mm-dd',
  };

  getArrestsInInterval(): void {
    //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    this.dataFetchService
      .getArrestsInInterval(start_date, end_date, this.cityFilter)
      .subscribe(response => {
        this.arrestsData = response;
      });
  }

  getCrimesInInterval(): void {
    //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    this.dataFetchService
      .getCrimesInInterval(start_date, end_date, this.cityFilter)
      .subscribe(response => {
        this.crimeData = response;
      });
  }

  getHistogram(): void {
    //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    this.dataFetchService
      .getHistogram(start_date, end_date, this.cityFilter)
      .subscribe(response => {
        this.histogramData = response;
        console.log(this.histogramData);
      });
  }

  getCities(): void {

    this.dataFetchService
      .getCities()
      .subscribe(response => {
        this.cities = response;
        console.log(this.cities);
      });
  }

  // getArrestsHistogram(): void {
  //   //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
  //   let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
  //   // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
  //   let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
  //   this.dataFetchService
  //     .getArrestsHistogram(start_date, end_date)
  //     .subscribe(response => {
  //       this.arrestsHistogramData = response;
  //       //console.log(this.arrestsHistogramData);
  //     });
  // }
}
