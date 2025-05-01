import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from 'src/app/models/flight.model';
import { FlightService } from 'src/app/service/flight.service';
import { UtilityService } from 'src/app/service/utility.service';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
  flights:Flight[] = []
  tempflights:Flight[] = []
  errorMessage:string
  userRole:string
  searchFieldSrc:string=""
  searchFieldDest:string=""
  searchFlight(){
    if(this.searchFieldSrc==="" || this.searchFieldDest==="")
      this.flights = this.tempflights
    else
   {
      this.flights = this.tempflights.filter(f=>f.arrivalLocation===this.searchFieldSrc && f.departureLocation===this.searchFieldDest)  
    }
    
  }
  updateFlight(id:number):void{
    let tempFlight:Flight
    for(let f of this.flights){
      if(f.flightId == id){
        tempFlight = f
      }
    }
    this.router.navigate(['/add-flight',id])
  }
  deleteFlight(id:number):void{
    this.service.deleteFlight(id).subscribe()
    this.loadFlights()
  }
  bookFlight(id:number):void{
    this.router.navigate(['/manage-booking',id])
  }
  loadFlights(){
    this.service.getFlights().subscribe((data)=>{
      this.flights = data
      this.tempflights = data
    })
  }
  navigateToBooking(flightId:number){
    this.router.navigate(['/book-form'])
  }
  constructor(private router:Router,private service:FlightService, public utilityService: UtilityService) { }

  ngOnInit(): void {
    this.loadFlights()
  }

}
