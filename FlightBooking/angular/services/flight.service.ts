import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../models/flight.model';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  public baseUrl:string="https://8080-aabcbaefeccfa320543897abfabbbafcaffedecbcfone.premiumproject.examly.io/api"
  getFlights():Observable<Flight[]>{
    return this.http.get<Flight[]>(this.baseUrl+"/flights")
  }
  getFlightById(flightId:number):Observable<Flight>{
    return this.http.get<Flight>(this.baseUrl+"/flights/"+flightId)
  }
  addFlight(flight:Flight):Observable<Flight>{
    return this.http.post<Flight>(this.baseUrl+"/flights",flight)
  }
  updateFlight(flight):Observable<Flight>{
    return this.http.put<Flight>(this.baseUrl+"/flight/"+flight.flightId,flight)
  }
  deleteFlight(flightId:number):Observable<void>{
    console.log(flightId);
    
    return this.http.delete<void>(this.baseUrl+"/flights/"+flightId)
  }
  constructor(private http:HttpClient) { }
}
