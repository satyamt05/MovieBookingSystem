import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs'; 

@Injectable({
  providedIn: 'root'
})
export class ShowService {

  constructor(private http:HttpClient) { }

  getShowList(): Observable<any> {  
    return this.http.get('http://localhost:8211/show/shows');  
  }  
  
  addShow(show: object): Observable<object> {  
    return this.http.post('http://localhost:8211/show/shows', show);  
  }  
  
  deleteShow(id: number): Observable<any> {  
    return this.http.delete('http://localhost:8211/show/shows/'+id, { responseType: 'text' });  
  }  
  
  getShow(id: number): Observable<Object> {  
    return this.http.get('http://localhost:8211/show/shows/'+id);  
  }  
  
  updateShow(show:object,value:any): Observable<Object> {  
    return this.http.put('http://localhost:8211/show/shows', value);  
  }  

  getShowByMovie(id:number):Observable<Object>{
    return this.http.get('http://localhost:8211/show/select/'+id);
  }



}
