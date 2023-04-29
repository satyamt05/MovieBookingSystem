import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Booking } from './add-booking/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  getBookingById(id: number) {
    throw new Error("Method not implemented.");
  }

  
  constructor(private http:HttpClient) { }  

  getBookingList(): Observable<any> {  
    return this.http.get("http://localhost:8211/movie/viewAll");  
  }  
  
  createBooking(booking: Booking): Observable<object> {  
    return this.http.post("http://localhost:8211/movie/addBooking",booking,{responseType:'text' as 'json'});  
  }  
  
  deleteBooking(id: number): Observable<any> {  
    return this.http.delete("http://localhost:8211/movie/deleteBooking/"+id, { responseType: 'text' });  
  }  
  
  viewBooking(id: number): Observable<Object> {  
    return this.http.get("http://localhost:8211/movie/viewBooking/"+id,{responseType:'text' as 'json'});  
  }  
  
  getSeatList(): Observable<any> {  
    return this.http.get("http://localhost:8211/movie/viewSeats");  
  } 
  
  getCustList():Observable<any>{
    return this.http.get("http://localhost:8211/customer/viewCustomers");
  }
  
  getSeatsById(id: number): Observable<any> {
    return this.http.get("http://localhost:8211/movie/view/"+id);  
  } 

  }


 

