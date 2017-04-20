import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DatePickerService {

  constructor() { }

  // Observable string sources
  private startDate : any; //= new Subject<any>();
  private endDate: any; // = new Subject<any>();
  private startSubject: Subject<any> = new Subject<any>();

  setStartDate(startDate: any): void {
    console.log(startDate);
    this.startDate = startDate;
    this.startSubject.next(startDate);
  }

  getStartDate(): Observable<any> {
    return this.startSubject.asObservable();
  }
}
