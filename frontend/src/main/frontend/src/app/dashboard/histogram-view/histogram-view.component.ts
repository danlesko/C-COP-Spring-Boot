import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import {GoogleChart} from 'angular2-google-chart/directives/angular2-google-chart.directive';

@Component({
  selector: 'app-histogram-view',
  templateUrl: './histogram-view.component.html',
  styleUrls: ['./histogram-view.component.css']
})
export class HistogramViewComponent implements OnInit, OnChanges {

  constructor() {
    //datePickerService.startDateAnnounced$.subscribe()
  }

  ngOnInit() {

  }

  ngOnChanges(changes: {[propKey: string]: SimpleChange}){

  }

  @Input() startDate: any;
  @Input() endDate: any;

  public histogram_ChartData = [
    ['Date', 'Arrests', 'Crimes'],
    ['Monday', 20, 80],
    ['Tuesday', 10, 50],
    ['Wednesday', 5, 35],
    ['Thursday', 15, 75],
    ['Friday', 25, 100] ];

  public histogram_ChartOptions  = {
    'title': 'Crimes Vs. Arrests',
    'isStacked': true
  };

}
