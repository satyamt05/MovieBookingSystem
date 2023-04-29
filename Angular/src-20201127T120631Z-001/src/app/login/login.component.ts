import { Component, OnInit } from '@angular/core';
import {FormControl,FormGroup, Validators} from '@angular/forms'; 
import {Admin} from '../admin';
import {AdminService} from '../admin.service'; 
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private adminService:AdminService,  private router:Router) { }
  adminDetail = new Admin(); 
  ngOnInit(): void {
  }
  loginform= new FormGroup({
    id:new FormControl(),
    password:new FormControl()
  });

  saveLogin(saveLogin){  
    this.adminDetail=new Admin();     
    this.adminDetail.id=this.LoginId.value;  
    this.adminDetail.password=this.LoginPassword.value;  
    this.save();  
  }  
  
   save() {    
         this.adminService.login(this.adminDetail.id,this.adminDetail.password).subscribe(  
          response => {  
        console.log('redirecting...');
        this.router.navigate(['/admin-dashboard']);  
      },  
    error => {  
        console.log("Error in authentication");  
        alert("Incorrect Id or password. Enter Valid details.");
    }  
  );  
    this.adminDetail = new Admin();  
  }  
  get LoginId(){  
    return this.loginform.get('id');  
  }  
  
  get LoginPassword(){  
    return this.loginform.get('password');  
  }  
 
}
