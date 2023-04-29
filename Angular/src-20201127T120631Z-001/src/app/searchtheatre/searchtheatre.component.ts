import { Component, OnInit } from '@angular/core';
import { Theatre } from '../theatre';
import { TheatreserviceService } from '../theatreservice.service';

@Component({
  selector: 'app-searchtheatre',
  templateUrl: './searchtheatre.component.html',
  styleUrls: ['./searchtheatre.component.css']
})
export class SearchtheatreComponent implements OnInit {

  tid:number;
  findTheatre:Theatre=new Theatre();
  errormess:string="";

  constructor(private t:TheatreserviceService) { }

  ngOnInit(): void {
  }
  searchOneTheatre():void
  { 
    this.t.searchOneTheatre(this.tid).subscribe(data=>
      { 
        this.findTheatre=data;
        alert("Theatre Found");
        this.errormess=undefined;
      },
      error=>
      {
        this.errormess="Theatre ID not found \nEnter a valid TheatreID ";
        alert(this.errormess);
      }
      );
  }

}
