import { Component, OnInit } from '@angular/core';
import { Screen} from "../screen";
import { TheatreserviceService } from '../theatreservice.service';

@Component({
  selector: 'app-updatescreen',
  templateUrl: './updatescreen.component.html',
  styleUrls: ['./updatescreen.component.css']
})
export class UpdatescreenComponent implements OnInit {
 sid:number;
 updatedScreen:any=new Screen();
 errormess:string="";
  constructor(private s:TheatreserviceService) { }

  ngOnInit(): void {
  }
  searchOneScreen():void
  {
     this.s.searchOneScreen(this.sid).subscribe(data=>
      {
        this.updatedScreen=data;
        alert(" Screen Found ");
        this.errormess=undefined;
      },
      error=>
      {
        this.errormess="Screen ID not found \nEnter a valid Screen ID";
        alert(this.errormess);
      }
      );   
  }

  updateOneScreen():void{
    this.s.updateOneScreen(this.updatedScreen).subscribe(data=>
      {
        alert(" Screen Updated ");
      }
    );
  }
}
