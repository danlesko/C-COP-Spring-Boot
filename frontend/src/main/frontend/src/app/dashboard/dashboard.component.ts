import { Component, OnInit } from '@angular/core';
import {IMyOptions, IMyDateRangeModel} from 'mydaterangepicker';
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

  constructor( private dataFetchService: DataFetchService) {
    //datePickerService.startDateAnnounced$.subscribe()

  }

  startDate: any;
  endDate: any;
  startTime: Date = new Date();
  endTime: Date = new Date();
  crimeData : any;
  arrestsData : any;

  ngOnInit() {
    var today = new Date()
    var priorDateStr = new Date().setDate(today.getDate()-30)
    this.today = today;
    var priorDate = new Date(priorDateStr);
    this.priorDate = priorDate;

    //console.log(this.today);
    //console.log(this.priorDate);
    this.model = {
      beginDate: {year: this.priorDate.getFullYear(), month: this.priorDate.getMonth()+1, day: this.priorDate.getDate()},
      endDate: {year: this.today.getFullYear(), month: this.today.getMonth()+1, day:this.today.getDate()}
    };
    console.log(this.model.endDate.day);


    this.getArrestsInInterval();
    this.getCrimesInInterval();
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
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };


  getArrestsInInterval(): void {
    //console.log("Hello?");
    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
      //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
      // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    this.dataFetchService
      .getArrestsInInterval(start_date, end_date)
      .subscribe(response => {
        this.arrestsData = response;
        //console.log("Arrest Data: " + JSON.stringify(this.arrestsData));
      });
  }

  getCrimesInInterval(): void {
    //console.log("Hello?");
    let start_date = this.model.beginDate.year +'-'+ this.model.beginDate.month +'-'+ this.model.beginDate.day + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    //this.priorDate.getFullYear()+'-'+(this.priorDate.getMonth()+1)+'-'+this.priorDate.getDate() + '%20' + this.startTime.getHours() + ':' + this.startTime.getMinutes();
    let end_date = this.model.endDate.year +'-'+ this.model.endDate.month +'-'+ this.model.endDate.day + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    // this.today.getFullYear()+'-'+(this.today.getMonth()+1)+'-'+this.today.getDate() + '%20' + this.endTime.getHours() + ':' + this.endTime.getMinutes();
    this.dataFetchService
      .getCrimesInInterval(start_date, end_date)
      .subscribe(response => {
        this.crimeData = response;
        //console.log("Arrest Data: " + this.crimeData);
      });
  }



}
