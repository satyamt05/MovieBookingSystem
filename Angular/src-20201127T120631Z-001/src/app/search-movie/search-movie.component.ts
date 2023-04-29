import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Movie } from '../movie';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-search-movie',
  templateUrl: './search-movie.component.html',
  styleUrls: ['./search-movie.component.css']
})
export class SearchMovieComponent implements OnInit {

  movie:any = new Movie();
  id:number;
  constructor(private movieservice : MovieService) { }  
  
  ngOnInit() {  
  }  
  
  form = new FormGroup({  
    id : new FormControl() 
  });  
  
  
  getData(movie)  
  {
      this.movieservice.getMovie(this.id).subscribe(  
       response => { 
          this.movie = response;
          console.log(this.movie);
        },  
        error => { 

          console.log("Movie Id does not exists."); 
          alert("Movie Id does not exists.");
        }  
      );  
  }  
  
  searchForm(searchform)  
  {  
        
        this.id = this.MovieId.value;
        this.getData(this.movie);  
        
  }  
  
  get MovieId()  
  {  
    return this.form.get('id');  
  }

  
}  