import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http:HttpClient) { }
  
  getCityList(): Observable<any> {  
     let url= "http://localhost:8211/city/viewCities";
       return this.http.get(url);
  } 
  
  createCity(city: object): Observable<any> {  
    let url= "http://localhost:8211/city/add";
        return this.http.post(url,city,{responseType:'text'});  
  }  

  deleteCity(id: number): Observable<any> {  
    let url= "http://localhost:8211/city/removeCity/"+id;
        return this.http.get(url,{responseType:'text'});
  }  
  
  getCityById(id: number): Observable<Object> {  
    let url= "http://localhost:8211/city/view/"+id;
        return this.http.get(url);  
  }  
}


