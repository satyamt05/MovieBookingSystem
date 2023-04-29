import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import {FormControl,FormGroup,Validators, AbstractControl} from '@angular/forms';  
import { Movie } from '../movie';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  constructor(private movieservice:MovieService,private router:Router) { }

  movie : Movie=new Movie();  
  submitted = false;
  check=false;

  ngOnInit(){
    this.submitted=false;  
  }

  moviesaveform=new FormGroup({
    name:new FormControl(" " , [Validators.required , Validators.minLength(4) ] ),  
    director:new FormControl(" ",[Validators.required,Validators.minLength(4), Validators.pattern("^[a-zA-Z \-\']+")]),  
    language:new FormControl(" " , [Validators.required , Validators.minLength(4),Validators.pattern("^[a-zA-Z \-\']+")] ),  
    releaseDate:new FormControl(" " , [Validators.required, Validators.pattern('[0-9]{2}/[0-9]{2}/[0-9]{4}')]),
  });  
  
  saveMovie(saveMovie){  
    this.movie=new Movie();     
    //this.movie.id=this.MovieId.value;
    this.movie.name=this.MovieName.value;  
    this.movie.director=this.Director.value;
    this.movie.language=this.Language.value;  
    this.movie.releaseDate=this.releaseDate.value;    
    this.submitted = true;  
    this.save();  

  }  
  
  save() {  
    if(this.moviesaveform.invalid){
      alert("Enter valid details");
      this.router.navigate(['/add-movie']);
    }
    else{
    this.movieservice.addMovie(this.movie)  
      .subscribe(data => console.log(data), error => console.log(error));  
    this.movie = new Movie(); 
    alert("Movie added successfully");
    this.router.navigate(['/admin-dashboard']);
    } 
  }  
   
  get MovieName(){  
    return this.moviesaveform.get('name');  
  }  
  get Director(){  
    return this.moviesaveform.get('director');  
  } 
  get Language(){  
    return this.moviesaveform.get('language');  
  } 
  get releaseDate(){  
    return this.moviesaveform.get('releaseDate');  
  }  
  
  addMovieForm(){  
    this.submitted=false;  
    this.moviesaveform.reset();  
  }

}  

