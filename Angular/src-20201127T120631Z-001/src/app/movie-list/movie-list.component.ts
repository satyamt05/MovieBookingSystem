import { Component, OnInit } from '@angular/core';
import {FormControl,FormGroup,Validators} from '@angular/forms'; 
import { Observable,Subject } from "rxjs"; 
import { MovieService } from '../movie.service';
import { Movie } from '../movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  constructor(private movieservice:MovieService) { } 
    
    moviesArray: any[] = [];
    dtTrigger: Subject<any>= new Subject();  
    
    movies: Observable<Movie[]>;  
    movie : Movie=new Movie();  
    deleteMessage=false;  
    movielist:any;  
    //isupdated = false;
    
    
    ngOnInit() {  
      //this.isupdated=false;  
     /* this.dtOptions = {  
        pageLength: 6,  
        stateSave:true,  
        lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],  
        processing: true  
      };*/     
      this.movieservice.getMovieList().subscribe(data =>{
          this.movies =data;  
          this.dtTrigger.next();  
      }) 
    }  
      
    deleteMovie(id: number) {  
      this.movieservice.deleteMovie(id).subscribe(data => {  
            console.log(data);  
            this.deleteMessage=true;  
            this.movieservice.getMovieList().subscribe(data =>{  
              this.movies=data  
              })  
          },  
          error => console.log(error));  
    }
  }