import { Component, OnInit } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Seat } from './Seat';
import { BookingService } from '../booking.service';
import { Booking } from '../add-booking/booking';
import { BookingDetailsComponent } from '../booking-details/booking-details.component';

@Component({
  selector: 'app-seat-booking',
  templateUrl: './seat-booking.component.html',
  styleUrls: ['./seat-booking.component.css']
})
export class SeatBookingComponent implements OnInit {

  constructor(private bookingservice:BookingService,private book:BookingDetailsComponent) { }

  
  dtTrigger: Subject<any>= new Subject();  
  bookings: Observable<Booking[]>;
  seats: Observable<Seat[]>;  
  seat : Seat=new Seat();  
  booking: Booking=new Booking();
 
 
      
   ngOnInit() {  
       this.bookingservice.getBookingList().subscribe(data =>{ 
         console.log(data);
    this.seats =data;  
    this.dtTrigger.next();  
    })  
  }  

}