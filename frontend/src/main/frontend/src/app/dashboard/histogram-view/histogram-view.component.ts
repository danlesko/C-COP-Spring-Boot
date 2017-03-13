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

}
