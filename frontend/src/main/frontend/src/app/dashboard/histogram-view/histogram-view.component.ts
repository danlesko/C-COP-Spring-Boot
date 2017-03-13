import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';

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
    ['Task', 'Hours per Day'],
    ['Work',     11],
    ['Eat',      2],
    ['Commute',  2],
    ['Watch TV', 2],
    ['Sleep',    7] ];

  public histogram_ChartOptions  = {
    title: 'My Daily Activities',
    width: '80%',
    height: '80%'
  };

}
