import { Component, OnInit } from '@angular/core';
import { TheatreserviceService } from '../theatreservice.service';
import { SelectorMatcher } from '@angular/compiler';
import { Screen } from "../screen";
import { from } from 'rxjs';


@Component({
  selector: 'app-deletescreen',
  templateUrl: './deletescreen.component.html',
  styleUrls: ['./deletescreen.component.css']
})
export class DeletescreenComponent implements OnInit {
  sid:number;
  errormess:String="";
  constructor(private s: TheatreserviceService ) { }

  ngOnInit(): void {
  }
  deleteScreen():void{

    this.s.deleteScreen(this.sid).subscribe(data=>
      {
        alert(" Screen Deleted Successfully ");
        this.errormess=undefined;
      },
      error=>
      {
        this.errormess="Screen ID not found \nEnter a valid Screen ID";
        alert(this.errormess);
      }
    );
  }

}
