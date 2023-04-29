import { Component, OnInit } from '@angular/core';
import { TheatreserviceService } from '../theatreservice.service';
import { Theatre } from '../theatre';
import { City } from '../city';
import { Observable } from 'rxjs';
import { CityService } from '../city.service';

@Component({
  selector: 'app-addtheatre',
  templateUrl: './addtheatre.component.html',
  styleUrls: ['./addtheatre.component.css']
})
export class AddtheatreComponent implements OnInit {

  t:Theatre=new Theatre();
  city:City=new City();
  cities:Observable<City[]>;
  constructor(private theatreserv:TheatreserviceService,private cityService:CityService) { }

  ngOnInit(): void {
    this.cityService.getCityList().subscribe(data =>
      {
        this.cities=data;
      })
  }

  addTheatre()
  {
    this.theatreserv.addNewTheatre(this.t).subscribe(data=>
      {
        alert("Theatre Added");
      }
     );
  }

}
