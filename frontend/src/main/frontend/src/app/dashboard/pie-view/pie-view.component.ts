// Pie component logic
// Implemented by Dan Lesko

import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-pie-view',
  templateUrl: './pie-view.component.html',
  styleUrls: ['./pie-view.component.css']
})
export class PieViewComponent implements OnInit, OnChanges {

  constructor() { }

  ngOnInit() { }

  // Passes changed data to the histogram options varaibles for updating the histogram upon changes
  ngOnChanges(changes: SimpleChanges) {
    if (this.crimeData != null) {
      this.numCrimes = this.crimeData.length;
    }
    if (this.arrestsData != null) {
      this.numArrests = this.arrestsData.length;
    }
    //console.log("Number of crimes changed to: " + this.numCrimes);
    //console.log("Number of arrests changed to: " + this.numArrests);
    this.pie_ChartData = [
      ['Crime vs Arrests', 'Occurrences'],
      ['Arrests',     this.numArrests],
      ['Crime',     this.numCrimes]
    ];




    let crimeData = null;
    let arrestData = null;

    if (this.arrestPieData != null) {
      //arrestData.unshift(this.arrestPieData);
      arrestData = this.arrestPieData.slice();
      arrestData.unshift(this.title);
      this.arrestPie_ChartData = arrestData;
    }

    if (this.crimePieData != null) {
      //crimeData.unshift(this.crimePieData);
      crimeData = this.crimePieData.slice();
      crimeData.unshift(this.title);
      this.crimePie_ChartData = crimeData;
    }

    //console.log(crimeData);
    //console.log(this.arrestPieData);



    //this.histogram_ChartData = this.histogramData;
  }

  // variables that listen for changes
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

  @Input() crimePieData: any;
  @Input() arrestPieData: any;

  // logic for displaying pie charts
  pieSelection: number = 1;

  pieSelect(whichPie: number): void{
    this.pieSelection = whichPie;
  }

  numCrimes : any = 0; // = Object.keys(this.crimeData).length;
  numArrests : any = 0; // = Object.keys(this.crimeData).length;

  title: Array<any> = ["Description", "Count"];

  // Below is instantiating default values and options for the pie charts in order to display correctly
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
    chartArea: {'width': '80%', 'height': '80%'},
    width: 1000,
    height: 800
  };

  /* Crime Pie */

  public crimePie_ChartData = [
    ['Crime vs Arrests', 'Occurrences'],
    ['Arrests',     20],
    ['Crime',     80]
  ];

  public crimePie_ChartOptions  = {
    'title': 'Crime Count',
    chartArea: {'width': '80%', 'height': '80%'},
    width: 500,
    height: 400
  };

  public crimePie_ChartOptionsLG  = {
    'title': 'Crime Count',
    chartArea: {'width': '80%', 'height': '80%'},
    width: 1000,
    height: 800
  };

  /* Arrest Pie */

  public arrestPie_ChartData = [
    ['Crime vs Arrests', 'Occurrences'],
    ['Arrests',     20],
    ['Crime',     80]
  ];

  public arrestPie_ChartOptions  = {
    'title': 'Arrest Count',
    chartArea: {'width': '80%', 'height': '80%'},
    width: 500,
    height: 400
  };

  public arrestPie_ChartOptionsLG  = {
    'title': 'Arrest Count',
    chartArea: {'width': '80%', 'height': '80%'},
    width: 1000,
    height: 800
  };
}
