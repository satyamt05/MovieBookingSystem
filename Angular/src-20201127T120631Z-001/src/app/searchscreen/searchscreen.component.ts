import { Component, OnInit } from '@angular/core';
import { Screen } from "../screen";
import { TheatreserviceService } from '../theatreservice.service';

@Component({
  selector: 'app-searchscreen',
  templateUrl: './searchscreen.component.html',
  styleUrls: ['./searchscreen.component.css']
})
export class SearchscreenComponent implements OnInit {
  sid:number;
  findScreen:Screen=new Screen();
  errormess:string="";
  constructor(private s: TheatreserviceService) { }

  ngOnInit(): void {
  }

  searchOneScreen():void{

    this.s.searchOneScreen(this.sid).subscribe(data=>
      {
        this.findScreen=data;
        alert(" Screen Found ");
        this.errormess=undefined;
      },
      error=>
      {
        this.errormess="Screen ID not found \nScreen a valid TheatreID";
        alert(this.errormess);
      }
      );
  }

}
