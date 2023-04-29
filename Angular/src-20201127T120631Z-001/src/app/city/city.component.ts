import { Component, OnInit } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import {CityService} from '../city.service';
import {City} from '../city';
@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  constructor(private cityservice:CityService) { }

  citiesArray: any[] = [];    
  dtTrigger: Subject<any>= new Subject();  
  
  cities: Observable<City[]>;  
  city : City=new City();  
  deleteMessage=false;  
  citylist:any;  
  isupdated = false;      
   

  ngOnInit(){
    this.isupdated=false;  
    this.deleteMessage=false;
    this.cityservice.getCityList().subscribe(data =>{  
    this.cities =data;  
    this.dtTrigger.next();  
    })  
  }

  deleteCity(id: number) {  
    this.cityservice.deleteCity(id).subscribe(  
        data => {  
          console.log(data);  
          this.deleteMessage=true;  
          this.cityservice.getCityList().subscribe(data =>{  
            this.cities =data  
            })  
        },  
        error => console.log(error));  
  }
}