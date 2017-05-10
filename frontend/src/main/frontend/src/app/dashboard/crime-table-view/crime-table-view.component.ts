// Crime table
// Implemented by Dan Lesko and Rachel Newkirk

import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { DataFetchService } from '../../global/data-fetch/data-fetch.service';

@Component({
  selector: 'app-crime-table-view',
  templateUrl: './crime-table-view.component.html',
  styleUrls: ['./crime-table-view.component.css'],
  providers: [DataFetchService]
})
export class CrimeTableViewComponent implements OnInit, OnChanges {

  constructor(private dataFetchService : DataFetchService) { }

  ngOnInit() {
  }

  changeLog: string[] = [];

  // function that listens for changes, right now just template code is used here as this function doesn't need to do anything for us.
  // however it must stay in order for changes to be "listened" for
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
  @Input() crimeData: any;
  @Input() locationFilter: any;
  @Input() narrativeFilter: any;
  @Input() placeFilter: any;
}
