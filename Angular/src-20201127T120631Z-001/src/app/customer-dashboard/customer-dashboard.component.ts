import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from '../add-booking/booking';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent implements OnInit {
  isupdated: boolean;
  booking : Booking=new Booking();
  deleteMessage: boolean;
  
  
  

  constructor(private router:Router,private bookingService:BookingService) { }

  ngOnInit(): void {
  }
  routerPage(pageName){
    switch(pageName){
      case 'homepage':
        this.router.navigate(['/homepage']);
    break;
  case 'movies':
    this.router.navigate(['/movies']);
    break;
case 'cancel-booking':
    this.router.navigate(['/cancel-booking']);
    break;
    }
  }

  changeisUpdate(){  
    this.isupdated=false;  
  }  

  cancelBooking(bookingId:number){
    console.log(bookingId);
    this.booking.id=bookingId;
    this.bookingService.deleteBooking(bookingId)  
    .subscribe(  
      data => { 
        this.deleteMessage=true;  
        console.log(data);  
        this.booking =data  
      })  
        
      error => console.log(error);  
      
  }
    
  
}
