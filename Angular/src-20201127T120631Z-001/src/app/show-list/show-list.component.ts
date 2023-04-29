import { Component, OnInit } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { ShowService } from '../show.service';
import { Show } from '../show';
import { Movie } from '../movie';

@Component({
  selector: 'app-show-list',
  templateUrl: './show-list.component.html',
  styleUrls: ['./show-list.component.css']
})
export class ShowListComponent implements OnInit {

  constructor(private showservice:ShowService) { } 
    
    showsArray: any[] = [];  
    //dtOptions: DataTables.Settings = {};  
    dtTrigger: Subject<any>= new Subject();  
    
    shows: Observable<Show[]>;  
    show: Show=new Show(); 
    deleteMessage=false;  
    showlist:any;  
    isupdated = false;      
     
    
    ngOnInit() {  
      this.isupdated=false;  
     /* this.dtOptions = {  
        pageLength: 6,  
        stateSave:true,  
        lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],  
        processing: true  
      };*/     
      this.showservice.getShowList().subscribe(data =>{
        // console.log(JSON.stringify(data));
      //   data.forEach(element => {
      //    // console.log(JSON.stringify(data));
      //    // console.log(element.movieId.id);
      //     var movieid = element.movieId.id;
      //  console.log(data.movieId=movieid);
      //   });
       
           this.shows=data;  
          this.dtTrigger.next();  
      })  
    }  
      
    deleteShow(id: number) {  
      this.showservice.deleteShow(id).subscribe(data => {  
            console.log(data);  
            this.deleteMessage=true;  
            this.showservice.getShowList().subscribe(data =>{  
              this.shows=data  
              })  
          },  
          error => console.log(error));  
    }  
    
    /*updateMovie(movie:object){
      this.movieservice.getMovie(id).subscribe(  
          data => {  
            this.movielist=data             
          },  
          error => console.log(error));  
    } 
    
    movieupdateform=new FormGroup({  
      student_id:new FormControl(),  
      student_name:new FormControl(),  
      student_email:new FormControl(),  
      student_branch:new FormControl()  
    });  
    
    updateMov(updstu){  
      this.student=new Student();   
     this.student.student_id=this.StudentId.value;  
     this.student.student_name=this.StudentName.value;  
     this.student.student_email=this.StudentEmail.value;  
     this.student.student_branch=this.StudentBranch.value;  
     console.log(this.StudentBranch.value);  
       
    
     this.studentservice.updateStudent(this.student.student_id,this.student).subscribe(  
      data => {       
        this.isupdated=true;  
        this.studentservice.getStudentList().subscribe(data =>{  
          this.students =data  
          })  
      },  
      error => console.log(error));  
    }  
    
    get StudentName(){  
      return this.studentupdateform.get('student_name');  
    }  
    
    get StudentEmail(){  
      return this.studentupdateform.get('student_email');  
    }  
    
    get StudentBranch(){  
      return this.studentupdateform.get('student_branch');  
    }  
    
    get StudentId(){  
      return this.studentupdateform.get('student_id');  
    }  
    
    changeisUpdate(){  
      this.isupdated=false;  
    }  
  }  
*/

}
