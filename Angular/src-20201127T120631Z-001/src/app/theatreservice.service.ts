import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Theatre } from './theatre';
import { Screen } from "./screen";

@Injectable({
  providedIn: 'root'
})
export class TheatreserviceService {

  constructor(private http:HttpClient) { }

  addNewTheatre(theatre:Theatre):Observable<any>
  {
  let url="http://localhost:8211/mtbs/theatres";
  return this.http.post(url,theatre,{responseType:'text'});
  }

  deleteTheatre(id:number):Observable<any>
  {
    let url="http://localhost:8211/mtbs/theatres/"+id;
    return this.http.delete(url, {responseType:'text'});
  }

  searchOneTheatre(id:number):Observable<any>
  {
    let url="http://localhost:8211/mtbs/theatres/"+id;
    return this.http.get(url);
  }

  viewAllTheatre():Observable<any>
  {
    let url= "http://localhost:8211/mtbs/theatres";
    return this.http.get(url);
  }

  updateOneTheatre(theatre:Theatre):Observable<any>
  {
    let url="http://localhost:8211/mtbs/theatres";
    return this.http.put(url,theatre,{responseType:'text'});
  }

  addNewScreen(screen:Screen):Observable<any>
  {
  let url="http://localhost:8211/mtbs/screens";
  return this.http.post(url,screen,{responseType:'text'});
  }

  deleteScreen(id:number):Observable<any>
  {
    let url="http://localhost:8211/mtbs/screens/"+id;
    return this.http.delete(url, {responseType:'text'});
  }

  searchOneScreen(id:number):Observable<any>
  {
    let url="http://localhost:8211/mtbs/screens/"+id;
    return this.http.get(url);
  }

  viewAllScreen():Observable<any>
  {
    /*let url= "http://localhost:8211/mtbs/screens";*/
    return this.http.get("http://localhost:8211/mtbs/screens");
  }

  updateOneScreen(screens:Screen):Observable<any>
  {
    let url="http://localhost:8211/mtbs/screens";
    return this.http.put(url,screen,{responseType:'text'});
  }


}
