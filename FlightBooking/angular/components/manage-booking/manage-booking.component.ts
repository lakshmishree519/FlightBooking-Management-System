import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Booking } from 'src/app/models/booking.model';
import { Flight } from 'src/app/models/flight.model';
import { BookingService } from 'src/app/service/booking.service';
import { FlightService } from 'src/app/service/flight.service';

@Component({
  selector: 'app-manage-booking',
  templateUrl: './manage-booking.component.html',
  styleUrls: ['./manage-booking.component.css']
})
export class ManageBookingComponent implements OnInit {
  bookings:Booking[] = []
  errorMessage:string
  flight:Flight;
  bookingForm:FormGroup
  constructor(private service:BookingService,private fb:FormBuilder,private route:ActivatedRoute, private flightService:FlightService){
    this.bookingForm = this.fb.group({
      flightNumber:[''],
      bookingDate:[''],
      numberOfPassengers:[0],
    })
  }
  addNewBooking(){
    if(this.bookingForm.valid){
      let booking = {
        flight:{
          flightNumber: this.flight.flightNumber
        },
        user:{
         userId:+sessionStorage.getItem('userId')
        },
          bookingDate:this.bookingForm.value.bookingDate,
          numberOfPassengers:+this.bookingForm.value.numberOfPassengers,
        }
        console.log(booking);
        this.service.addBooking(booking).subscribe((result)=>{
          console.log(booking);
          this.loadBookings()
        },(error)=>{
          console.log(error);
        })
    }
  }
  loadBookings(){
    let userId = +sessionStorage.getItem('userId')
    this.service.getBookingByUser(userId).subscribe((data)=>{
      this.bookings = data
    })
  }
  
  ngOnInit(): void {
    this.loadBookings()
    let flightId = +this.route.snapshot.paramMap.get('id')
    this.flightService.getFlightById(flightId).subscribe((result)=>{
      this.flight=result
      console.log(this.flight)
      console.log(this.flight.flightNumber)
      this.bookingForm.setValue({
        flightNumber:this.flight.flightNumber,
        bookingDate:'',
        numberOfPassengers:0
      })
    })
    
    
  }

}
