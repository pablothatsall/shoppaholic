
import { Component,OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import{CustomerService} from './customer.service'
import{Customer} from './customer.model'


@Component({
    selector: 'navigation',
    templateUrl: './navigation.component.html'
  })
  export class NavigationComponent {

  searchtext:String;
  userLogged:Customer;
  
  constructor(private router: Router,activatedRoute: ActivatedRoute,
    private customerService: CustomerService) {
    activatedRoute.params.subscribe(params=>{
             this.userLogged=customerService.customer;
        });

    
     }
      search(){
      this.router.navigate(['search/'+this.searchtext]);
    }
}