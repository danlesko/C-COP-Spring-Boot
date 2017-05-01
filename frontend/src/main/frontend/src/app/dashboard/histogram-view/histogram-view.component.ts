import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import {GoogleChart} from 'angular2-google-chart/directives/angular2-google-chart.directive';
import { SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-histogram-view',
  templateUrl: './histogram-view.component.html',
  styleUrls: ['./histogram-view.component.css']
})
export class HistogramViewComponent implements OnInit, OnChanges {

  constructor() { }

  ngOnInit() {}

  @Input() startDate: any;
  @Input() endDate: any;
  @Input() histogramData: any;
  title: Array<any> = ["Date", "Arrests", "Crimes"];

  ngOnChanges(changes: SimpleChanges){
    if(this.histogramData != null) {
      this.histogramData.unshift(this.title);
    }

    this.histogram_ChartData = this.histogramData;
  }

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

  public histogram_ChartOptionsLG  = {
    'title': 'Crimes Vs. Arrests',
    'isStacked': true,
    chartArea: {'width': '100%', 'height': '90%'},
    width: 1500,
    height: 750
  };


}
