import { Component, OnInit } from '@angular/core';
import { TheatreserviceService } from '../theatreservice.service';
import { Screen } from "../screen";
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-viewscreen',
  templateUrl: './viewscreen.component.html',
  styleUrls: ['./viewscreen.component.css']
})
export class ViewscreenComponent implements OnInit {

  constructor(private s:TheatreserviceService) { }
  screens: Observable<Screen[]>;  
  screen: Screen=new Screen();
  dtTrigger: Subject<any>= new Subject();  
   ngOnInit(){
    this.s.viewAllScreen().subscribe(data=>     
      {
        this.screens=data;  
        this.dtTrigger.next();  
    })  
  } 
}
