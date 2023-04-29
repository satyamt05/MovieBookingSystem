import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  routerPage(pageName){
    switch(pageName){
      case 'admin-menu':
        this.router.navigate(['/login']);
          break;
      case 'customer-menu':
        this.router.navigate(['/custlogin']);
            break;
      case 'homepage':
        this.router.navigate(['/homepage']);
        break;
      case 'customer-register':
        this.router.navigate(['/customer-register']);
        break;
    }
  }

}
