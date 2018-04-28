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

  editProfile(userfirstname: string, userlastname: string, usermail: string, usertelephone: number, useraddress: string){

	  
  

    if (userfirstname!=null)
    {
    this.customer.firstName=userfirstname;
    }

    if (userlastname!=null){
    this.customer.lastName=userlastname;
    }

    if (usermail!=null){
    this.customer.mail=usermail;}
    
    if (useraddress!=null){
    this.customer.address=useraddress;
    }
    
    
    if (usertelephone!=null){
    this.customer.telephone=usertelephone;}
    


this.customerService.editCustomer(this.customer).subscribe(
      customerx =>{ this.customer=customerx;},
      error => console.error(error)
    )


  }
              
}