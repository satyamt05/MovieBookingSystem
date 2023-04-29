import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';  
import { Observable } from 'rxjs'; 
import { Router } from '@angular/router';  
  

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient,private router: Router) { }

  login(id:number,password:String): Observable<object>{
    let url="http://localhost:8211/customer/login/id/"+id+"/password/"+password;
    return this.http.get(url);
  }
  
  addCustomer(cust:Object):Observable<object>{
    return this.http.post("http://localhost:8211/customer/customers/",cust);
  }
}