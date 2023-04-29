import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  routerPage(pageName){
    switch(pageName){
      case 'homepage':
        this.router.navigate(['/homepage']);
        break;
      case 'add-booking':
        this.router.navigate(['/add-booking']);
        break;

      case 'view-booking':
          this.router.navigate(['/view-booking']);
          break;
      case 'seat-booking':
          this.router.navigate(['/seat-booking']);
          break;
      case 'view-customer':
          this.router.navigate(['/view-customer']);
            break;
      case 'view-movie':
          this.router.navigate(['/view-movie']);
            break;
      case 'add-movie':
          this.router.navigate(['/add-movie']);
            break;
      case 'search-movie':
          this.router.navigate(['/search-movie']);
           break;
      case 'update-movie':
          this.router.navigate(['/update-movie']);
          break;
      case 'theatre':
            this.router.navigate(['/theatre']);
            break;
      case 'screen':
              this.router.navigate(['/screen']);
            break;
      case 'add-show':
            this.router.navigate(['/add-show']);
            break;
      case 'view-show':
            this.router.navigate(['/view-show']);
            break;
      case 'search-show':
            this.router.navigate(['/search-show']);
              break;
      case 'add-city':
            this.router.navigate(['/add-city']);
              break;
      case 'view-city':
            this.router.navigate(['/view-city']);
             break;
      
    }
  }

}
