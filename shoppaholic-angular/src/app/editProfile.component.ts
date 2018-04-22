
import { Component } from '@angular/core';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import {Customer} from './customer.model';
import { CustomerService } from './customer.service';

@Component({
    selector: 'editProfile',
    templateUrl: './editProfile.component.html'
  })
  export class EditProfileComponent {
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
   editProfile() {
//TO DO 
}
}
