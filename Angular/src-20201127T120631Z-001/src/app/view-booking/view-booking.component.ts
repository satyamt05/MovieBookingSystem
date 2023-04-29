import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Booking } from '../add-booking/booking';
import { FormGroup, FormControl } from '@angular/forms';
import { BookingService } from '../booking.service';
import { Customer } from '../view-customer/Customer';
import { Show } from '../show';


@Component({
  selector: 'app-view-booking',
  templateUrl: './view-booking.component.html',
  styleUrls: ['./view-booking.component.css']
})
export class ViewBookingComponent implements OnInit {
  isupdated: boolean;
  

  constructor(private bookingservice:BookingService) { }

  bookingsList: any[] = []; 
  dtTrigger: Subject<any>= new Subject();  
  customers: Observable<Customer[]>;
  shows:Observable<Show[]>;
  show:Show=new Show();
  customer:Customer;
  bookings: Observable<Booking[]>;  
  booking : Booking=new Booking();  
  deleteMessage=false; 

 
      
   ngOnInit() {  
         this.bookingservice.getBookingList().subscribe(data =>{ 
         console.log(data);
    this.bookings =data;  
    this.dtTrigger.next();  
    })  
  }  
    
  deleteBooking(bookingId: number) {  
    this.bookingservice.deleteBooking((bookingId))  
      .subscribe(  
        data => {  
          console.log(data);  
          this.deleteMessage=true;  
          this.bookingservice.getBookingList().subscribe(data =>{  
            this.bookings =data  
            })  
        },  
        error => console.log(error));  
  } 

   changeisUpdate(){  
    this.isupdated=false;  
  }  
  viewBooking(booking:Booking){
    
  } 

  

  }
 

 
     
 
  


