import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../models/booking.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  public baseUrl:string="https://8080-aabcbaefeccfa320543897abfabbbafcaffedecbcfone.premiumproject.examly.io/api"
  getBookings():Observable<Booking[]>{
    return this.http.get<Booking[]>(this.baseUrl+"/bookings")
  }
  getBookingByUser(userId:number):Observable<Booking[]>{
    return this.http.get<Booking[]>(this.baseUrl+"/bookings/user/"+userId)
  }
  getBookingById(bookingId:number):Observable<Booking>{
    return this.http.get<Booking>(this.baseUrl+"/bookings/"+bookingId)
  }
  deleteBooking(bookingId:number):Observable<void>{
    return this.http.delete<void>(this.baseUrl+"/bookings/"+bookingId)
  }
  addBooking(booking:any):Observable<Booking>{
    return this.http.post<Booking>(this.baseUrl+"/bookings",booking)
  }
  updateBooking(booking:Booking):Observable<Booking>{
    return this.http.put<Booking>(this.baseUrl+"/"+booking.bookingId,booking)
  }
  constructor(private http:HttpClient) { }
}
