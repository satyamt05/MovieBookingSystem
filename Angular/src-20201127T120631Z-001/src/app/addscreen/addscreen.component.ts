import { Component, OnInit } from '@angular/core';
import { TheatreserviceService } from '../theatreservice.service';
import { Screen } from "../screen";
import { Observable } from 'rxjs';
import { Theatre } from '../theatre';
import { FormControl, Validators, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-addscreen',
  templateUrl: './addscreen.component.html',
  styleUrls: ['./addscreen.component.css']
})
export class AddscreenComponent implements OnInit {
  constructor(private screenserve:TheatreserviceService) { }
  theatres:Observable<Theatre[]>
  screen:any=new Screen();
  submitted = false; 

  ngOnInit() {
    this.screenserve.viewAllTheatre().subscribe(data=>
      {
        this.theatres=data;
      }
      )
  }
screensaveform=new FormGroup({  
  id:new FormControl("",[Validators.required, Validators.minLength(4)]),
  name:new FormControl(" " , [Validators.required , Validators.minLength(2) ] ),  
  theatreId:new FormControl("",[Validators.required, Validators.minLength(3)]),
}); 

saveScreen(saveScreen){  
  this.screen=new Screen();     
  this.screen.id=this.ScreenId.value
  this.screen.name=this.ScreenName.value;  
  this.screen.theatreId=this.TheatreId.value;
  this.save();  
} 

save() {  
  this.screenserve.addNewScreen(this.screen).subscribe(data =>    
  console.log(data), error => console.log(error));  
  this.screen = new Screen();  
  alert("Screen Added Successfully");
}  

get ScreenId(){  
  return this.screensaveform.get('id');  
}  
get ScreenName(){  
  return this.screensaveform.get('name');  
}  

get TheatreId(){
  return this.screensaveform.get('theatreId');
}

addScreenForm(){  
  this.submitted=false; 
  this.screensaveform.reset(); 
}  
}  



