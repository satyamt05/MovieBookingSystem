import { Component, OnInit } from '@angular/core';
import { BookingService } from '../booking.service';
import { Customer } from './Customer';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
 
  bookings: any;
  dtTrigger: any;
  customers: Observable<Customer[]>;
 

  constructor(private bookingService:BookingService) { }
  ngOnInit() {  
    this.bookingService.getCustList().subscribe(data =>{ 
    console.log(data);
    this.customers =data;  
   // this.dtTrigger.next();  
   })  


}  



}
