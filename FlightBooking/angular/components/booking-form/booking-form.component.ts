import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit {
  bookingForm:FormGroup
  constructor(private fb:FormBuilder,private service:BookingService){
    this.bookingForm = this.fb.group({
      bookingId:[0,Validators.required],
      bookingDate:['',Validators.required],
      numberOfPassengers:[0,Validators.required],
      status:['',Validators.required],
      flightId:[0,Validators.required],
      userId:[0,Validators.required]
    })
  }
  addNewBooking(){
    if(this.bookingForm.valid){
      this.service.addBooking(this.bookingForm.value).subscribe()
      this.bookingForm.reset()
    }
  }
  ngOnInit(): void {
  }

}
