import { Component, OnInit } from '@angular/core';
import { Customer } from '../view-customer/Customer';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { Admin } from '../admin';

@Component({
  selector: 'app-custlogin',
  templateUrl: './custlogin.component.html',
  styleUrls: ['./custlogin.component.css']
})
export class CustloginComponent implements OnInit {

  constructor(private custService:CustomerService,  private router:Router) { }
  custDetail = new Customer(); 
  id:number;
  ngOnInit(): void {
  }
  loginform= new FormGroup({
    id:new FormControl(),
    password:new FormControl()
  });

  saveLogin(saveLogin){  
    this.custDetail=new Customer();     
    this.custDetail.id=this.LoginId.value;  
    this.custDetail.password=this.LoginPassword.value;  
    this.save();  
  }  
  
   save() {    
         this.custService.login(this.custDetail.id,this.custDetail.password).subscribe(  
          response => {  
        console.log('redirecting...');
        this.id=this.custDetail.id;
        console.log(this.id);
        this.router.navigate(['/customer-dashboard']);  
      },  
    error => {  
        console.log("Error in authentication");  
        alert("Incorrect Id or password. Enter Valid details.");
    }  
  );  
    this.custDetail = new Customer();  
  }  
  get LoginId(){  
    return this.loginform.get('id');  
  }  
  
  get LoginPassword(){  
    return this.loginform.get('password');  
  }  
 
}
