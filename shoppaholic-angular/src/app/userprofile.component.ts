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
isAdmin:boolean;

  	 constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http,  private customerService: CustomerService){
       this.isAdmin=false;
       let id = activatedRoute.params.subscribe(params => {
       	 this.customerService.getCustomer(params['id']).subscribe(
      customer =>{
        this.customer=customerService.customer;
        if(this.customer.roles.indexOf("ADMIN")==1 || this.customer.roles.indexOf("ADMIN")==0){
          this.isAdmin=true;
        }
      
      },
      error =>  console.error(error)
      );
     
      
  });

  }
              
}