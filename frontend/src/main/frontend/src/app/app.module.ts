import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { DatepickerModule } from 'ng2-bootstrap';
import { TimepickerModule } from 'ng2-bootstrap';
import { ModalModule } from 'ng2-bootstrap';
import { MyDateRangePickerModule } from 'mydaterangepicker';
import { GoogleChart } from 'angular2-google-chart/directives/angular2-google-chart.directive';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HistogramViewComponent } from './dashboard/histogram-view/histogram-view.component';
import { MapViewComponent } from './dashboard/map-view/map-view.component';
import { PieViewComponent } from './dashboard/pie-view/pie-view.component';
import { CrimeTableViewComponent } from './dashboard/crime-table-view/crime-table-view.component';
import { ArrestTableViewComponent } from './dashboard/arrest-table-view/arrest-table-view.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    HistogramViewComponent,
    MapViewComponent,
    PieViewComponent,
    CrimeTableViewComponent,
    ArrestTableViewComponent,
    GoogleChart
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    DatepickerModule.forRoot(),
    TimepickerModule.forRoot(),
    ModalModule.forRoot(),
    MyDateRangePickerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
