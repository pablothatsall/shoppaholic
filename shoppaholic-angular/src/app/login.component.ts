import { Component } from '@angular/core';
import {CustomerService} from './customer.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
    selector: 'login',
    templateUrl: './login.component.html'
  })
  export class LoginComponent {
  	 constructor(private router: Router, activatedRoute: ActivatedRoute, private customerService: CustomerService) { }

logIn(event: any, email: string, password: string) {

    event.preventDefault();

    this.customerService.logIn(email, password).subscribe(
      u =>{ console.log(u),
      this.navigate();
      },
      //error => alert('Invalid user or password')
      error=>{console.log(error),
      alert('Invalid user or password')}
    );}

      navigate(){
     this.router.navigate(['/']);
     
  }


}