import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';  
import { HttpClientModule } from '@angular/common/http';  
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { ViewBookingComponent } from './view-booking/view-booking.component';
import { SeatBookingComponent } from './seat-booking/seat-booking.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MovieComponent } from './movie/movie.component';
import { SearchMovieComponent } from './search-movie/search-movie.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { AddtheatreComponent } from './addtheatre/addtheatre.component';
import { AddscreenComponent } from './addscreen/addscreen.component';
import { SearchtheatreComponent } from './searchtheatre/searchtheatre.component';
import { SearchscreenComponent } from './searchscreen/searchscreen.component';
import { ViewscreenComponent } from './viewscreen/viewscreen.component';
import { ViewtheatreComponent } from './viewtheatre/viewtheatre.component';
import { DeletetheatreComponent } from './deletetheatre/deletetheatre.component';
import { DeletescreenComponent } from './deletescreen/deletescreen.component';
import { UpdatetheatreComponent } from './updatetheatre/updatetheatre.component';
import { UpdatescreenComponent } from './updatescreen/updatescreen.component';
import { TheatreComponent } from './theatre/theatre.component';
import { ScreenComponent } from './screen/screen.component';
import { ShowComponent } from './show/show.component';
import { SearchShowComponent } from './search-show/search-show.component';
import { ShowListComponent } from './show-list/show-list.component';
import { CityComponent } from './city/city.component';
import { AddCityComponent } from './add-city/add-city.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { CmovieListComponent } from './cmovie-list/cmovie-list.component';
import { NewBookingComponent } from './new-booking/new-booking.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { CustloginComponent } from './custlogin/custlogin.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { CustRegisterComponent } from './cust-register/cust-register.component';


@NgModule({
  declarations: [
    AppComponent,
    AddBookingComponent,
    ViewBookingComponent,
    SeatBookingComponent,
    ViewCustomerComponent,
    AdminDashboardComponent,
    CustomerDashboardComponent,
    MovieListComponent,
    MovieComponent,
    SearchMovieComponent,
    UpdateMovieComponent,
    AddtheatreComponent,
    AddscreenComponent,
    SearchtheatreComponent,
    SearchscreenComponent,
    ViewscreenComponent,
    ViewtheatreComponent,
    DeletetheatreComponent,
    DeletescreenComponent,
    UpdatetheatreComponent,
    UpdatescreenComponent,
    TheatreComponent,
    ScreenComponent,
    ShowComponent,
    SearchShowComponent,
    ShowListComponent,
    CityComponent,
    AddCityComponent,
    CancelBookingComponent,
    CmovieListComponent,
    NewBookingComponent,
    HomepageComponent,
    LoginComponent, 
    CustloginComponent,
    BookingDetailsComponent,
    CustRegisterComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,  
    ReactiveFormsModule,  
    HttpClientModule, 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
