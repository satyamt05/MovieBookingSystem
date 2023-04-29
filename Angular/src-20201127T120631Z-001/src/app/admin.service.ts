import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';  
import { Observable } from 'rxjs';  
import { Admin} from './admin';  
import { Router } from '@angular/router';  
  

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient,private router: Router) { }

  login(id:number,password:String): Observable<object>{
    let url="http://localhost:8211/admin/login/"+id+"/"+password;
    return this.http.get(url);
  }

}
