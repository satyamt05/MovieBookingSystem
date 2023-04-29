import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs';  

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http:HttpClient) { }
  getAdmin(id:number,password:String): Observable<object>{
    return this.http.get('http://localhost:8211/admin/login/{id}/{password}');
  }
}

