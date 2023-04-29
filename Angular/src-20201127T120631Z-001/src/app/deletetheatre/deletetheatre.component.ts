import { Component, OnInit } from '@angular/core';
import { TheatreserviceService } from '../theatreservice.service';
import { Theatre } from '../theatre';

@Component({
  selector: 'app-deletetheatre',
  templateUrl: './deletetheatre.component.html',
  styleUrls: ['./deletetheatre.component.css']
})
export class DeletetheatreComponent implements OnInit {
  tid:number;
  errormess:string="";
  constructor(private t:TheatreserviceService) { }
  ngOnInit(): void {
  }
  deleteTheatre():void{

    this.t.deleteTheatre(this.tid).subscribe(data=>
      {
        alert("Theatre Deleted Successfully");
        this.errormess=undefined;
      },
      error=>
      {
        this.errormess="Threatre ID not found \nEnter a valid Threatre ID";
        alert(this.errormess);
      }
      );
  }

}
