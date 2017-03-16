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
    ['Crime vs Arrests', 'Occurrences'],
    ['Arrests',      20],
    ['Crime',     80]

     ];

  public pie_ChartOptions  = {
    'title': 'Crimes',
    chartArea: {'width': '80%', 'height': '80%'},
    width: 500,
    height: 400
  };

}
