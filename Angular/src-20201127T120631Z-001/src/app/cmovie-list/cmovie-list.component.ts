import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Subject, Observable } from 'rxjs';
import { Movie } from '../movie';
import { ShowService } from '../show.service';
import { Show } from '../show';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cmovie-list',
  templateUrl: './cmovie-list.component.html',
  styleUrls: ['./cmovie-list.component.css']
})
export class CmovieListComponent implements OnInit {

  constructor(private movieservice:MovieService,private showservice:ShowService,private router:Router) { }

  moviesArray: any[] = [];
 // dtTrigger: Subject<any>= new Subject();  
  
  shows: Observable<Show[]>;
  movies: Observable<Movie[]>;  
  selectedMovie : any=new Movie();
  selectedShow : any=new Show();


  movielist:any;
  movie:Movie=new Movie();

  ngOnInit() {
    this.movieservice.getMovieList().subscribe(data =>{
      this.movies =data;   
  }) 
  }
 
  selectMovie(id:number){
    console.log(id);
    this.showservice.getShowByMovie(id).subscribe(data =>{
      console.log(data);
      this.selectedShow=data;  
      this.shows=this.selectedShow;
        console.log(this.selectedShow);
        
  });
}
 
bookMovie(show){
  //console.log(show);
  this.router.navigate(['/new-booking']);
  //window.location.reload();
}


}
