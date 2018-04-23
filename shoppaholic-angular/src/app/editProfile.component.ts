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

	this.customer.idCustomer=this.customer.idCustomer;
    this.customer.firstName=userfirstname;
    this.customer.lastName=userlastname;
    this.customer.mail=usermail;
    this.customer.password=this.customer.password;
    this.customer.address=useraddress;
    this.customer.imageUrl= this.customer.imageUrl;
    this.customer.telephone=usertelephone;
    this.customer.myOrders=  this.customer.myOrders;
    this.customer.myCart= this.customer.myCart;
    this.customer.roles=   this.customer.roles;
    this.customer.idLogged=this.customer.idLogged;


this.customerService.editCustomer(this.customer).subscribe(
      customer =>{ this.customer=customer;},
      error => console.error(error)
    )


  }
              
}