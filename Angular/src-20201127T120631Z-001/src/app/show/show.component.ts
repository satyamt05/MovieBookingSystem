import { Component, OnInit } from '@angular/core';
import {FormControl,FormGroup,Validators} from '@angular/forms';  
import { ShowService } from '../show.service';
import { Show } from '../show';
import { Movie } from '../movie';
import { Screen } from "../screen";
import { Observable, Subject } from 'rxjs';
import { MovieService } from '../movie.service';
import { TheatreserviceService } from '../theatreservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  constructor(private showservice:ShowService,private movieservice:MovieService,private screenService:TheatreserviceService,private router:Router) { }
  movies: Observable<Movie[]>;
  show :Show=new Show();  
  movie : Movie=new Movie(); 
  submitted = false;  
  screens:Observable<Screen[]>;
  screen:Screen=new Screen();
  dtTrigger: Subject<any>= new Subject();  

  ngOnInit(): void {
    this.submitted=false; 
    // this.setTimeValidators();
    this.movieservice.getMovieList().subscribe(data =>{
      this.movies =data;  
    });
  this.screenService.viewAllScreen().subscribe(data =>
    {
      this.screens=data;
    });
  }


  showsaveform=new FormGroup({
    name:new FormControl(" " , [Validators.required , Validators.minLength(4),Validators.pattern("^[a-zA-Z \-\']+")]),  
    startTime:new FormControl(" ", [Validators.required, Validators.pattern('^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$')]),  
    endTime:new FormControl(" " , [Validators.required,Validators.pattern('^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$')] ), 
    availableSeats:new FormControl("",[Validators.required, Validators.minLength(2),Validators.pattern("^[0-9]*$")]),
    showPrice:new FormControl("",[Validators.required, Validators.minLength(2),Validators.pattern("^[0-9]*$")]),
    screenId:new FormControl("",[Validators.required]),
    movieId:new FormControl("",[Validators.required]),
  });  
  
  private newMethod() {
    return this;
  }

  saveShow(saveShow){  
    this.show=new Show();     
    this.show.name=this.ShowName.value;  
    this.show.startTime=this.StartTime.value;
    this.show.endTime=this.EndTime.value;     
    this.show.availableSeats=this.AvailableSeats.value;
    this.show.showPrice=this.ShowPrice.value;
    this.show.screenId=this.ScreenId.value
    this.show.movieId=this.MovieId.value;
    this.submitted = true;  
    this.save();  
  }  
  
    
  
  save() {  
    if(this.showsaveform.invalid){
      alert("Enter valid details");
      this.router.navigate(['/add-show']);
    }
    else{
    this.showservice.addShow(this.show)  
      .subscribe(data => console.log(data), error => console.log(error));  
    this.show = new Show();  
    alert("Show added successfully");
    this.router.navigate(['/admin-dashboard']);
  }  
}
  
  get ShowName(){  
    return this.showsaveform.get('name');  
  }  
  get StartTime(){  
    return this.showsaveform.get('startTime');  
  } 
  get EndTime(){  
    return this.showsaveform.get('endTime');  
  } 
  get AvailableSeats(){  
    return this.showsaveform.get('availableSeats');  
  } 
  get ShowPrice(){  
    return this.showsaveform.get('showPrice');  
  }  
  get ScreenId(){  
    return this.showsaveform.get('screenId');  
  }
  get MovieId(){
    return this.showsaveform.get('movieId');
  }
  
  addShowForm(){  
    this.submitted=false;  
    this.showsaveform.reset();  
  }


}  

