import { Component, OnInit } from '@angular/core';
import { Customer } from '../view-customer/Customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-cust-register',
  templateUrl: './cust-register.component.html',
  styleUrls: ['./cust-register.component.css']
})
export class CustRegisterComponent implements OnInit {
  cust:Customer=new Customer();
  constructor(private custService:CustomerService) { }
  ngOnInit() : void{
  }
  customer:any=new Customer();

  addCustomer()
  {
    this.custService.addCustomer(this.cust).subscribe(data=>
      {
        this.customer=data;
        alert("Registered Successfully.");
        alert("Registered with id "+this.customer.id);
      }
     );
  }

}
