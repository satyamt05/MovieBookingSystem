import { Component, OnInit } from '@angular/core';
import { Booking } from '../add-booking/booking';
import { Customer } from '../view-customer/Customer';
import { Show } from '../show';
import { ShowService } from '../show.service';
import { Observable } from 'rxjs';
import { BookingService } from '../booking.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CustloginComponent } from '../custlogin/custlogin.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-booking',
  templateUrl: './new-booking.component.html',
  styleUrls: ['./new-booking.component.css']
})
export class NewBookingComponent implements OnInit {
  response: any;
  
  constructor(private bookingservice:BookingService,private showService:ShowService,private router:Router){}

  booking : Booking=new Booking(); 
  submitted = false; 
  message:any;
  customer:Customer=new Customer();
  customers: Observable<Customer[]>;
  show:Show=new Show(); 
  shows: Observable<Show[]>;
  //bookings: Array<Booking> = [];
  confirmedBooking:any=new Booking();

 

  ngOnInit() {  
    this.submitted=false;
    this.bookingservice.getCustList().subscribe(data =>{
      this.customers =data;}),
    this.showService.getShowList().subscribe(data =>{
      this.shows =data;     
  } ); 
}
  
     bookingsaveform=new FormGroup({  
  
    showId:new FormControl('',[Validators.required]), 
    bookingDate:new FormControl('' , [Validators.required  ] ),  
    noOfSeats:new FormControl('' , [Validators.required ] ),  
    totalCost:new FormControl('' , [Validators.required ] ), 
    customer:new FormControl('' , [Validators.required  ] ),  

      
  });  
  
  saveBooking(savebooking){  
    this.booking=new Booking();     
    this.booking.showId=this.ShowId.value;  
    this.booking.bookingDate=this.BookingDate.value;  
    this.booking.noOfSeats=this.NoOfSeats.value; 
    this.booking.customer=this.CustId.value; 
    this.submitted = true;  
     this.save();  
  }  
  
    
  
  save() {  
    this.booking.totalCost=0.0; 
    this.bookingservice.createBooking(this.booking)  
      .subscribe(data => console.log(data), error => console.log(error));  
    this.booking = new Booking();  
    console.log(this.booking)
    alert("booking confirmed");
    this.router.navigate(['/booking-details']);
   } 


  
 
  
  get ShowId(){  
    return this.bookingsaveform.get('showId');  
  }  
  
  get BookingDate(){  
    return this.bookingsaveform.get('bookingDate');  
  } 
  
  get NoOfSeats(){  
    return this.bookingsaveform.get('noOfSeats');  
  } 
  get CustId(){  
    return this.bookingsaveform.get('customer');  
  } 
  //console.log
  
// addBookingForm(){  
    //this.submitted=false;  
 //  this.bookingsaveform.reset();  
 // } */ 
}  
  