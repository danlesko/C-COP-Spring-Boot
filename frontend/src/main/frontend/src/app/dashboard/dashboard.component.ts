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

  startDate: any;
  endDate: any;
  startTime: Date = new Date();
  endTime: Date = new Date();
  crimeData : any;
  arrestsData : any;
  crimeHistogramData : any;
  arrestsHistogramData : any;

  locationFilter: any;
  narrativeFilter: any;
  placeFilter: any;
  firstNameFilter: any;
  lastNameFilter: any;
  offenseFilter: any;

  ngOnInit() {
    var today = new Date()
    var priorDateStr = new Date().setDate(today.getDate()-12)
    this.today = today;
    var priorDate = new Date(priorDateStr);
    this.priorDate = priorDate;

    this.model = {
      beginDate: {year: this.priorDate.getFullYear(), month: this.priorDate.getMonth()+1, day: this.priorDate.getDate()},
      endDate: {year: this.today.getFullYear(), month: this.today.getMonth()+1, day:this.today.getDate()}
    };
    console.log(this.model.endDate.day);

    this.getArrestsInInterval();
    this.getCrimesInInterval();

    this.getCrimesHistogram();
    this.getArrestsHistogram();
  }

  // dateRangeChanged callback function called when the user apply the date range. This is
  // mandatory callback in this option. There are also optional inputFieldChanged and
  // calendarViewChanged callbacks.
  onDateRangeChanged(event: IMyDateRangeModel) {
    // event properties are: event.beginDate, event.endDate, event.formatted,
    // event.beginEpoc and event.endEpoc
    this.startDate = event.beginDate;
    this.endDate = event.endDate;
    console.log(this.startDate);
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
      .getArrestsInInterval(start_date, end_date)
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
      .getCrimesInInterval(start_date, end_date)
      .subscribe(response => {
        this.crimeData = response;
      });
  }

  getCrimesHistogram(): void {
    //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    this.dataFetchService
      .getCrimesHistogram(start_date, end_date)
      .subscribe(response => {
        this.crimeHistogramData = response;
        console.log(this.crimeHistogramData);
      });
  }

  getArrestsHistogram(): void {
    //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    this.dataFetchService
      .getArrestsHistogram(start_date, end_date)
      .subscribe(response => {
        this.arrestsHistogramData = response;
        console.log(this.arrestsHistogramData);
      });
  }
}
