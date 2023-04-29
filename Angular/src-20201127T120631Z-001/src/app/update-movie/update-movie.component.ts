import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit {

  updatedMovie:any=new Movie();
  id:number;
  constructor(private movieservice:MovieService) { }

  ngOnInit(): void {
  }
  searchMovie(){
    this.movieservice.getMovie(this.id).subscribe(
      data=>{
        this.updatedMovie=data;
        alert("Movie Found");
      },
      error => {  
        console.log("Movie Id does not exists."); 
        alert("Movie Id does not exists.");
      }  
    )
  }
  updateMovie(){
    this.movieservice.updateMovie(this.updatedMovie.id,this.updatedMovie).subscribe(
      data =>{
        alert("Movie updated");
      }
      );
  }
}
