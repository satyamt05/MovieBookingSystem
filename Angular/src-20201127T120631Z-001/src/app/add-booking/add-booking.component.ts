import { Component, OnInit } from '@angular/core';
import {FormControl,FormGroup,Validators} from '@angular/forms';
import { Booking } from './booking';
import { BookingService } from '../booking.service';
import { Customer } from '../view-customer/Customer';
import { Show } from '../show';
import { Observable } from 'rxjs';
import { ShowService } from '../show.service';

@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {
 
 

  constructor(private bookingservice:BookingService,private showService:ShowService) { }

  booking : Booking=new Booking();  
  submitted = false; 
  message:any;
  customer:Customer=new Customer();
  customers: Observable<Customer[]>;
  show:Show=new Show(); 
  shows: Observable<Show[]>;
  
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
    this.booking.totalCost=this.TotalCost.value; 
    this.booking.customer=this.CustId.value; 
    this.submitted = true;  
     this.save();  
  }  
  
    
  
  save() {  
    this.bookingservice.createBooking(this.booking)  
      .subscribe(data => console.log(data), error => console.log(error));  
    this.booking = new Booking();  
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
  get TotalCost(){  
    return this.bookingsaveform.get('totalCost');  
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

  


