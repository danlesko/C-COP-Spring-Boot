import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { DataFetchService } from '../../global/data-fetch/data-fetch.service';
//import {DatePickerService} from '../../global/date-picker/date-picker.service';

@Component({
  selector: 'app-map-view',
  templateUrl: './map-view.component.html',
  styleUrls: ['./map-view.component.css']
})

export class MapViewComponent implements OnInit, OnChanges {

  @Input() startDate: any;
  @Input() endDate: any;
  @Input() startTime: any;
  @Input() crimeData: any;
  @Input() arrestsData: any;

  markers: marker[] = [
    {
      lat: 51.673858,
      lng: 7.815982,
      label: 'A',
      draggable: true
    },
    {
      lat: 51.373858,
      lng: 7.215982,
      label: 'B',
      draggable: false
    },
    {
      lat: 51.723858,
      lng: 7.895982,
      label: 'C',
      draggable: true
    }
  ];

  // markers: marker[] = [];

  constructor(private dataFetchService : DataFetchService) {
    //datePickerService.startDateAnnounced$.subscribe()
  }

  ngOnInit() {
    this.fetchCrime();
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

  changeLog: string[] = [];

  fetchCrime(): void {
    this.dataFetchService
      .fetchCrime()
      .subscribe(response => {
        this.crimeData = response;
        //console.log("Crime Data: " + JSON.stringify(response));
      });
  }

  convertStringToNumber(value: string): number {
    console.log(value);
    return +value;
  }

}

interface marker {
  lat: number;
  lng: number;
  label?: string;
  draggable: boolean;
}
