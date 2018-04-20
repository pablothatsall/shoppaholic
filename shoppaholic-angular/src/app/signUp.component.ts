import { Component } from '@angular/core';
import { Customer } from './customer.model';
import { CustomerService } from './customer.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'signUp',
    templateUrl: './signUp.component.html'
  })
  export class SignUpComponent {
    user : Customer;

    constructor(private router:Router, private customerService:CustomerService){
      this.user={firstName:"", lastName:"", password:"", address:"", mail:"", telephone:null, myOrders:null, myCart:null, roles:["ROLE_USER"], idLogged:false};

  }
  
  signIn(event:any,firstname:string, lastname:string, email:string, password:string, address:string, telephone:number){
    event.preventDefault();

    console.log(firstname);
    this.user.idCustomer=6;
    this.user.firstName=firstname;
    this.user.lastName=lastname;
    this.user.mail=email;
    this.user.password=password;
    this.user.address=address;
    this.user.imageUrl=null;
    this.user.telephone=telephone;
    this.user.myOrders=null;
    this.user.myCart=null;
    this.user.roles=["ROLE_USER"];
    this.user.idLogged=false;


    this.customerService.createCustomer(this.user).subscribe(
        user => {
            this.user=user;
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