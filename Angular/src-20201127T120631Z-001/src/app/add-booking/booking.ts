import { Customer } from '../view-customer/Customer';
import { Show } from '../show';

export class Booking {  
  
    id:number;  
    showId:Show;  
    bookingDate:String;  
    noOfSeats:number;
    totalCost:number;
    customer:Customer;  
}  