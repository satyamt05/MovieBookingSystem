import { Component, OnInit } from '@angular/core';
import { TheatreserviceService } from '../theatreservice.service';
import { Theatre } from '../theatre';
import { CityService } from '../city.service';
import { Observable } from 'rxjs';
import { City } from '../city';

@Component({
  selector: 'app-updatetheatre',
  templateUrl: './updatetheatre.component.html',
  styleUrls: ['./updatetheatre.component.css']
})
export class UpdatetheatreComponent implements OnInit {

  tid:number;
  updatedTheatre:Theatre=new Theatre();
  city:City=new City();
  cities:Observable<City[]>;
  errormess:String="";

  constructor(private t:TheatreserviceService,private cityService:CityService) { }

  ngOnInit(): void {
      this.cityService.getCityList().subscribe(data =>
        {
          this.cities=data;
        })
    }
  searchOneTheatre():void{

    this.t.searchOneTheatre(this.tid).subscribe(data=>
      {    
           this.updatedTheatre=data;
           alert(" Theatre Found ");
           this.errormess=undefined;
      },
      error=>
      {
        this.errormess="Theatre ID not found \nEnter a valid Theatre ID";
        alert(this.errormess);
      }     
      );   
      }
      updateOneTheatre():void{

        this.t.updateOneTheatre(this.updatedTheatre).subscribe(data=>
          {
            alert(" Theatre Updated ");
          });
  }

}
