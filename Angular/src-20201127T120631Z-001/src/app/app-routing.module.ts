import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { ViewBookingComponent } from './view-booking/view-booking.component';
import { SeatBookingComponent } from './seat-booking/seat-booking.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { MovieComponent } from './movie/movie.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { SearchMovieComponent } from './search-movie/search-movie.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { TheatreComponent } from './theatre/theatre.component';
import { ScreenComponent } from './screen/screen.component';
import { AddtheatreComponent } from './addtheatre/addtheatre.component';
import { DeletetheatreComponent } from './deletetheatre/deletetheatre.component';
import { UpdatetheatreComponent } from './updatetheatre/updatetheatre.component';
import { SearchtheatreComponent } from './searchtheatre/searchtheatre.component';
import { ViewtheatreComponent } from './viewtheatre/viewtheatre.component';
import { AddscreenComponent } from './addscreen/addscreen.component';
import { DeletescreenComponent } from './deletescreen/deletescreen.component';
import { UpdatescreenComponent } from './updatescreen/updatescreen.component';
import { SearchscreenComponent } from './searchscreen/searchscreen.component';
import { ViewscreenComponent } from './viewscreen/viewscreen.component';
import { ShowComponent } from './show/show.component';
import { ShowListComponent } from './show-list/show-list.component';
import { SearchShowComponent } from './search-show/search-show.component';
import { AddCityComponent } from './add-city/add-city.component';
import { CityComponent } from './city/city.component';
import { CustomerDashboardComponent } from './customer-dashboard/customer-dashboard.component';
import { CmovieListComponent } from './cmovie-list/cmovie-list.component';
import { NewBookingComponent } from './new-booking/new-booking.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { CustloginComponent } from './custlogin/custlogin.component';
import { BookingDetailsComponent } from './booking-details/booking-details.component';
import { CustRegisterComponent } from './cust-register/cust-register.component';


const routes: Routes = [ 
  { path: '', redirectTo: 'homepage', pathMatch: 'full' },  
  { path: 'add-booking', component: AddBookingComponent },  
  { path: 'view-booking', component: ViewBookingComponent },
  { path: 'seat-booking', component: SeatBookingComponent },
  { path: 'view-customer', component: ViewCustomerComponent },
  { path: 'admin-dashboard', component: AdminDashboardComponent },
  { path: 'customer-dashboard', component: CustomerDashboardComponent },
  { path: 'add-movie', component: MovieComponent },
  { path: 'view-movie', component: MovieListComponent },
  { path: 'search-movie', component: SearchMovieComponent },
  { path: 'update-movie', component: UpdateMovieComponent },
  { path: 'theatre', component: TheatreComponent },
  { path: 'screen', component: ScreenComponent },
  { path: 'addtheatre', component: AddtheatreComponent },
  { path: 'deletetheatre', component: DeletetheatreComponent },
  { path: 'updatetheatre', component: UpdatetheatreComponent },
  { path: 'searchtheatre', component: SearchtheatreComponent },
  { path: 'viewtheatre', component: ViewtheatreComponent },
  { path: 'addscreen', component: AddscreenComponent },
  { path: 'deletescreen', component: DeletescreenComponent },
  { path: 'updatescreen', component: UpdatescreenComponent },
  { path: 'searchscreen', component: SearchscreenComponent },
  { path: 'viewscreen', component: ViewscreenComponent },
  { path: 'add-show', component: ShowComponent },
  { path: 'view-show', component: ShowListComponent },
  { path: 'search-show', component: SearchShowComponent },
  { path: 'add-city', component: AddCityComponent },
  { path: 'view-city', component: CityComponent },
  { path: 'movies', component: CmovieListComponent },
  { path: 'new-booking', component: NewBookingComponent },
  { path: 'homepage', component: HomepageComponent },
  { path: 'login', component: LoginComponent },
  {path:'custlogin', component: CustloginComponent},
  { path: 'booking-details', component: BookingDetailsComponent},
  { path: 'customer-register', component: CustRegisterComponent},
];  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
