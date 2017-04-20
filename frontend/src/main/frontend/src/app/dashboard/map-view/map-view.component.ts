import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { DataFetchService } from '../../global/data-fetch/data-fetch.service';

@Component({
  selector: 'app-map-view',
  templateUrl: './map-view.component.html',
  styleUrls: ['./map-view.component.css'],
  styles: [`
    .sebm-google-map-container {
       height: 300px;
     }
  `]
})
export class MapViewComponent implements OnInit, OnChanges {
  @Input() crimeData: any;
  @Input() arrestsData: any;

  constructor(private dataFetchService : DataFetchService) { }

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
      });
  }
}

interface marker {
  lat: number;
  lng: number;
  label?: string;
  draggable: boolean;
}
