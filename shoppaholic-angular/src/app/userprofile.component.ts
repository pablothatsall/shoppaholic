import { Component } from '@angular/core';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import {Customer} from './customer.model';
import { CustomerService } from './customer.service';
@Component({
    selector: 'userprofile',
    templateUrl: './userprofile.component.html'
  })
  export class userprofileComponent {

customer:Customer;

  	 constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private customerService: CustomerService){
       let id = activatedRoute.params.subscribe(params => {
       	 this.customerService.getCustomer(params['id']).subscribe(
      customer =>{
        this.customer=customerService.customer;
        
      
      },
      error =>  console.error(error)
      );
     
      
  });

  }
              
}