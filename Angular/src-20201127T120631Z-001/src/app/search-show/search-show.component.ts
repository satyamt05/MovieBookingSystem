import { Component, OnInit } from '@angular/core';
import { Show } from '../show';
import { ShowService } from '../show.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Movie } from '../movie';

@Component({
  selector: 'app-search-show',
  templateUrl: './search-show.component.html',
  styleUrls: ['./search-show.component.css']
})
export class SearchShowComponent implements OnInit {

  movie:any=new Movie();
  show:any = new Show(); 
  id:number;
  constructor(private showservice : ShowService) { }  
  
  ngOnInit() {  
   // this.getData(this.movie.id);
  }  
  
  form = new FormGroup({  
    id : new FormControl(),
  });  
  
  
  getData(show)  
  {
      this.showservice.getShow(this.id).subscribe(  
        response => { 
          this.show = response;
          console.log(this.show);
        },  
        error => {  
          console.log("Show Id does not exists"); 
          alert("Show Id does not exists"); 
        }  
      );  
  }  
  
  searchForm(searchform)  
  {  
        this.id = this.ShowId.value;
        this.getData(this.show);  
  }  
  
  get ShowId()  
  {  
    return this.form.get('id');  
  }

  
}  
