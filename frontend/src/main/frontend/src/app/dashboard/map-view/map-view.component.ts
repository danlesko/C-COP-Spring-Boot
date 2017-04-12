import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
//import {DatePickerService} from '../../global/date-picker/date-picker.service';

@Component({
  selector: 'app-map-view',
  templateUrl: './map-view.component.html',
  styleUrls: ['./map-view.component.css']

})
export class MapViewComponent implements OnInit, OnChanges {

  constructor() {
    //datePickerService.startDateAnnounced$.subscribe()
  }

  ngOnInit() {

  }

  ngOnChanges(changes: {[propKey: string]: SimpleChange}){
    let log: string[] = [];
    for (let propName in changes) {
      let changedProp = changes[propName];
      let to = JSON.stringify(changedProp.currentValue);
      if (changedProp.isFirstChange()) {
        log.push(`Initial value of ${propName} set to ${to}`);
      } else {
        let from = JSON.stringify(changedProp.previousValue);
        log.push(`${propName} changed from ${from} to ${to}`);
      }
    }
    this.changeLog.push(log.join(', '));

  }

  @Input() startDate: any;
  @Input() endDate: any;
  @Input() startTime: any;

  changeLog: string[] = [];

}
