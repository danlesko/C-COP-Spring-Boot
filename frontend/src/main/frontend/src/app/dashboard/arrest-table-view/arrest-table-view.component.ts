import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { DataFetchService } from "../../global/data-fetch/data-fetch.service";

@Component({
  selector: 'app-arrest-table-view',
  templateUrl: './arrest-table-view.component.html',
  styleUrls: ['./arrest-table-view.component.css'],
  providers: [DataFetchService]
})
export class ArrestTableViewComponent implements OnInit, OnChanges {

  constructor(private dataFetchService: DataFetchService) { }

  ngOnInit() {
    //this.fetchArrests();
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
    //console.log(JSON.stringify(this.arrestsData));
  }

  @Input() startDate: any;
  @Input() endDate: any;
  @Input() startTime: any;
  @Input() arrestsData: any;

  changeLog: string[] = [];

  //arrestData : any;

  fetchArrests(): void {
    this.dataFetchService
      .fetchArrests()
      .subscribe(response => {
        this.arrestsData = response;
        //console.log("Arrest Data: " + JSON.stringify(response));
      });
  }

  showData(): void{
    console.log(JSON.stringify(this.arrestsData));
  }

}
