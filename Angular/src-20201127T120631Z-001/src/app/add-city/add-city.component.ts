import { Component, OnInit } from '@angular/core';
import {CityService} from '../city.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';  
import { City } from '../city';

@Component({
  selector: 'app-add-city',
  templateUrl: './add-city.component.html',
  styleUrls: ['./add-city.component.css']
})
export class AddCityComponent implements OnInit {

  constructor(private cityservice:CityService) { }
  city : City=new City();  
  submitted = false;  
  ngOnInit(){
    this.submitted=false;
  }
  cityform=new FormGroup({  
    id:new FormControl(),  
    name:new FormControl()
  });  
  
  saveCity(saveCity){  
    this.city=new City();     
    this.city.id=this.CityID.value;  
    this.city.name=this.CityName.value;  
    this.submitted = true;  
    this.save();  
  }  
  
    
  
  save() {  
    this.cityservice.createCity(this.city)  
      .subscribe(data => console.log(data), error => console.log(error));  
    this.city = new City();  
  }  
  
  get CityName(){  
    return this.cityform.get('name');  
  }  
  
  get CityID(){  
    return this.cityform.get('id');  
  }  
  
  
  addCityForm(){  
    this.submitted=false;  
    this.cityform.reset();  
  }  
}  

