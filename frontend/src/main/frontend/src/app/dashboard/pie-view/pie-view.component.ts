import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import {GoogleChart} from 'angular2-google-chart/directives/angular2-google-chart.directive';

@Component({
  selector: 'app-pie-view',
  templateUrl: './pie-view.component.html',
  styleUrls: ['./pie-view.component.css']
})
export class PieViewComponent implements OnInit, OnChanges {

  constructor() {
    //datePickerService.startDateAnnounced$.subscribe()
  }

  ngOnInit() {

  }

  ngOnChanges(changes: {[propKey: string]: SimpleChange}){

  }

  @Input() startDate: any;
  @Input() endDate: any;

  public pie_ChartData = [
    ['Task', 'Hours per Day'],
    ['Work',     11],
    ['Eat',      2],
    ['Commute',  2],
    ['Watch TV', 2],
    ['Sleep',    7] ];

  public pie_ChartOptions  = {
    title: 'My Daily Activities',
    width: 400,
    height: 400
  };

}
