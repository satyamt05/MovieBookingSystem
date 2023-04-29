import { Component, OnInit } from '@angular/core';
import { TheatreserviceService } from '../theatreservice.service';
import { Theatre } from '../theatre';


@Component({
  selector: 'app-viewtheatre',
  templateUrl: './viewtheatre.component.html',
  styleUrls: ['./viewtheatre.component.css']
})
export class ViewtheatreComponent implements OnInit {

  constructor(private t:TheatreserviceService) { }
  theatres:Theatre[]=[];
  ngOnInit(): void {

    this.t.viewAllTheatre().subscribe(data=>this.theatres=data);
  }

}
