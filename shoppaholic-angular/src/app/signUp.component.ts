import { Component } from '@angular/core';
import { Customer } from './customer.model';
import { CustomerService } from './customer.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'signUp',
    templateUrl: './signUp.component.html'
  })
  export class SignUpComponent {
    user : Customer = null;

    constructor(private router:Router, private userService:CustomerService){
      this.user={firstname:"", lastname:"", password:"", address:"", mail:"", telephone:null, myOrders:null, myCart:null, roles:["ROLE_USER"], idLogged:false};

  }
  
  signIn(event:any,firstname:string, lastname:string, email:string, password:string, address:string, telephone:number){
    event.preventDefault();

    console.log(firstname);
    
    this.user.firstname=firstname;
    this.user.lastname=lastname;
    this.user.mail=email;
    this.user.password=password;
    this.user.address=address;
    this.user.telephone=telephone;


    this.userService.createCustomer(this.user).subscribe(
        user => {
            console.log(user);
            this.goToLogin();
    },
        error => console.error(error)
    )
 }

 goToLogin(){
  this.router.navigate(['/login']);
}
}