// Map controller logic
// Implemented by Dan Lesko and Josh Sharo

import { Component, OnInit, Input, OnChanges, SimpleChange } from '@angular/core';
import { SimpleChanges } from '@angular/core';
import { DataFetchService } from '../../global/data-fetch/data-fetch.service';
import * as L from "leaflet";

@Component({
  selector: 'app-map-view',
  templateUrl: './map-view.component.html',
  styleUrls: ['./map-view.component.css'],
  styles: [`
    .sebm-google-map-container {
       height: 100%;
     }
  `]
})
export class MapViewComponent implements OnInit, OnChanges {
  @Input() crimeData: any;
  @Input() arrestsData: any;

  constructor(private dataFetchService : DataFetchService) { }

  map : any;
  mapLG: any;
  numCrimes : any = 0; // = Object.keys(this.crimeData).length;
  numArrests : any = 0; // = Object.keys(this.crimeData).length;

  ngOnInit() {
    //this.fetchCrime();

    this.map = L.map('map',{scrollWheelZoom:true}).setView([39.154743, -77.240515], 10);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(this.map);

    // Large map view wasn't loading correctly so scrapped it for the sake of time. Better luck next time!

    /*this.mapLG = L.map('mapLG',{scrollWheelZoom:true}).setView([39.154743, -77.240515], 10);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(this.mapLG);*/


  }

  // variables for use by the leaflet map
  LeafIcon : any = L.Icon;

  redIcon = new this.LeafIcon({iconUrl: 'assets/img/red.png'});
  blueIcon = new this.LeafIcon({iconUrl: 'assets/img/blue.png'});
  arrestMarkerGroup : any;
  crimeMarkerGroup : any;
  arrestMarkerGroupLG : any;
  crimeMarkerGroupLG : any;

  // function that listens for changes in data that will be passed to the map in the form of a marker
  ngOnChanges(changes: SimpleChanges){
    if (this.arrestMarkerGroup != null) {
      //console.log("Did this fire?");
      this.map.removeLayer(this.arrestMarkerGroup);
      //this.mapLG.removeLayer(this.arrestMarkerGroupLG);

    }
    if (this.crimeMarkerGroup != null) {
      this.map.removeLayer(this.crimeMarkerGroup);
      //this.mapLG.removeLayer(this.crimeMarkerGroupLG);

    }

    if (this.crimeData != null) {
      this.numCrimes = this.crimeData.length;
      //this.numCrimes = this.crimeData.length;

      //console.log("The Crime Data!");
      //console.log(this.crimeData);

      let markers = new Array();
      let markersLG = new Array();


      if (this.numCrimes < 100) {
        for (let crime of this.crimeData) {
          markers.push(L.marker([crime.latitude, crime.longitude], {icon: this.redIcon}).addTo(this.map).bindPopup(crime.narrative));
          //markersLG.push(L.marker([crime.latitude, crime.longitude], {icon: this.redIcon}).addTo(this.map).bindPopup(crime.narrative));
        }
      } else {
        for (var i = 0 ; i < 100; i++) {
          markers.push(L.marker([this.crimeData[i].latitude, this.crimeData[i].longitude], {icon: this.redIcon}).addTo(this.map).bindPopup(this.crimeData[i].narrative));
          //markersLG.push(L.marker([crime.latitude, crime.longitude], {icon: this.redIcon}).addTo(this.map).bindPopup(crime.narrative));
        }
      }

      //console.log("Num crime markers" + markers.length);

      this.crimeMarkerGroup = L.layerGroup(markers).addTo(this.map);
      //this.crimeMarkerGroupLG = L.layerGroup(markersLG).addTo(this.mapLG);

    }

    if(this.arrestsData != null){
      this.numArrests = this.arrestsData.length;
      //console.log("The Arrest Data!");
      //console.log(this.arrestsData);

      let markers = new Array();
      let markersLG = new Array();

      //console.log("Num arrests = " + this.numArrests);

      if (this.numArrests < 100) {
        for (let arrest of this.arrestsData) {
          markers.push(L.marker([arrest.latitude, arrest.longitude], {icon: this.blueIcon}).bindPopup(arrest.offense));
          //markersLG.push(L.marker([arrest.latitude, arrest.longitude], {icon: this.blueIcon}).bindPopup(arrest.offense));
        }
      } else {
        for (var i = 0 ; i < 100; i++) {
          markers.push(L.marker([this.arrestsData[i].latitude, this.arrestsData[i].longitude], {icon: this.blueIcon}).bindPopup(this.arrestsData[i].offense));
          //markersLG.push(L.marker([arrest.latitude, arrest.longitude], {icon: this.blueIcon}).bindPopup(arrest.offense));
        }
      }

      //console.log("Num arrest markers" + markers.length);


      this.arrestMarkerGroup = L.layerGroup(markers).addTo(this.map);
      //this.arrestMarkerGroupLG = L.layerGroup(markersLG).addTo(this.mapLG);
    }


  }

  changeLog: string[] = [];

  // wanted to implement loading bar but never got around to it
  doneLoading : any = false;

  doneLoad() : void {
    this.doneLoading = true;
  }
}
