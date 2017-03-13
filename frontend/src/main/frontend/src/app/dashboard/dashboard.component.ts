import { Component, OnInit } from '@angular/core';
import {IMyOptions, IMyDateRangeModel} from 'mydaterangepicker';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  providers: []
})
export class DashboardComponent implements OnInit {

  constructor() {
    //datePickerService.startDateAnnounced$.subscribe()
  }

  ngOnInit() {
    this.startDate= '';
    this.endDate='';
  }

  startDate: any;
  endDate: any;
  public startTime: Date = new Date();
  public endTime: Date = new Date();



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
    dateFormat: 'dd.mm.yyyy',
  };






}
