import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { SimpleChanges } from '@angular/core';
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

  ngOnChanges(changes: SimpleChanges) {
    if (this.crimeData != null){
      this.numCrimes = this.crimeData.length;
    }
    if (this.arrestsData != null){
      this.numArrests = this.arrestsData.length;
    }
    console.log("Number of crimes changed to: " + this.numCrimes);
    console.log("Number of arrests changed to: " + this.numArrests);
    this.pie_ChartData = [
      ['Crime vs Arrests', 'Occurrences'],
      ['Arrests',     this.numArrests],
      ['Crime',     this.numCrimes]
    ];
  }

  @Input() startDate: any;
  @Input() endDate: any;

  @Input() crimeData: any;
  @Input() arrestsData: any;

  @Input() firstNameFilter: any;
  @Input() lastNameFilter: any;
  @Input() offenseFilter: any;

  @Input() locationFilter: any;
  @Input() narrativeFilter: any;
  @Input() placeFilter: any;

  numCrimes : any;// = Object.keys(this.crimeData).length;
  numArrests : any; // = Object.keys(this.crimeData).length;

  public pie_ChartData = [
    ['Crime vs Arrests', 'Occurrences'],
    ['Arrests',     20],
    ['Crime',     80]
     ];

  public pie_ChartOptions  = {
    'title': 'Crimes vs. Arrests',
    chartArea: {'width': '80%', 'height': '80%'},
    width: 500,
    height: 400
  };

  public pie_ChartOptionsLG  = {
    'title': 'Crimes',
    chartArea: {'width': '100%', 'height': '100%'},
    width: 1000,
    height: 1000
  };


}
