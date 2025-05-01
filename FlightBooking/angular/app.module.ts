import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ErrorComponent } from './components/error/error.component';
import { FlightListComponent } from './components/flight-list/flight-list.component';
import { ManageBookingComponent } from './components/manage-booking/manage-booking.component';
import { MyHistoryComponent } from './components/my-history/my-history.component';
import { AddFlightComponent } from './components/add-flight/add-flight.component';
import { BookingFormComponent } from './components/booking-form/booking-form.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './components/register/register.component';
import { EditFlightComponent } from './components/edit-flight/edit-flight.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ErrorComponent,
    FlightListComponent,
    ManageBookingComponent,
    MyHistoryComponent,
    AddFlightComponent,
    BookingFormComponent,
    LoginComponent,
    RegisterComponent,
    EditFlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
