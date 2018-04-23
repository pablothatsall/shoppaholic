import { Component } from '@angular/core';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import {Customer} from './customer.model';
import { CustomerService } from './customer.service';

@Component({


    selector: 'manageUser',
    templateUrl: './manageUser.component.html'
  })
  export class ManageUserComponent {

  	customers:Customer[];

  	 constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private customerService: CustomerService){
       let id = activatedRoute.params.subscribe(params => {
       	 this.customerService.getCustomers().subscribe(
      customers =>{
        this.customers=customers;
        
      
      },
      error =>  console.error(error)
      );
     
      
  });

  }

    deleteUser(id:number){
    this.customerService.deleteUser(id).subscribe(
       
      customers =>{ 
        customers
       
        },
      error => console.error(error)
    )
  }

}