import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './login.service';

@Component({
    selector: 'login',
    templateUrl: './login.component.html'
  })
  export class LoginComponent {
  

  constructor(private loginService: LoginService, private router: Router) { }


  logIn(event: any, user: string, pass: string) {

    event.preventDefault();
  
    this.loginService.logIn(user, pass).subscribe( 
      u => {console.log(u),
      alert('user logged!')
      this.router.navigate(['/home'])
    },
      //error => alert('Invalid user or password')
      error => this.router.navigate(['/loginError'])
    );
  }

  logOut() {
    this.loginService.logOut().subscribe(
      response => { },
      error => console.log('Error when trying to log out: ' + error)
    );
  }

}