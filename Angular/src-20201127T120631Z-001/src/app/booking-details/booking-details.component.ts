import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Customer } from '../view-customer/Customer';
import { Show } from '../show';
import { Booking } from '../add-booking/booking';
import { BookingService } from '../booking.service';
import { Router } from '@angular/router';
import { Seat } from '../seat-booking/Seat';

@Component({
  selector: 'app-booking-details',
  templateUrl: './booking-details.component.html',
  styleUrls: ['./booking-details.component.css']
})
export class BookingDetailsComponent implements OnInit {

  constructor(private bookingservice:BookingService,private router:Router) { }

  dtTrigger: Subject<any>= new Subject();  
  customers: Observable<Customer[]>;
  shows:Observable<Show[]>;
  show:Show=new Show();
  customer:Customer;
  bookings: Observable<Booking[]>;  
  booking : Booking=new Booking();  
  deleteMessage=false; 

  seats: Observable<String[]>;  

  ngOnInit(): void {
    this.bookingservice.getBookingList().subscribe(data =>{ 
      console.log(data);
 this.bookings =data;  
 this.dtTrigger.next();  
 })  
  }

  seatsBooked(id:number){
    this.bookingservice.getSeatsById(id).subscribe(data =>{console.log(data);
      this.seats =data;  
    this.dtTrigger.next();  
    }) ; 
  }
}

