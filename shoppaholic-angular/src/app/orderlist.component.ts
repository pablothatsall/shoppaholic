import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
import {Pedido} from './pedido.model';
import{CustomerService} from './customer.service';

@Component({
    selector: 'orderlist',
    templateUrl: './orderlist.component.html'
  })
  export class OrderlistComponent {
  	 	orders:Pedido[];
	constructor(private router: Router, activatedRoute: ActivatedRoute, private http: Http, private customerService: CustomerService){
		let id = activatedRoute.params.subscribe(params => {
			this.customerService.getOrders(params['id']).subscribe(
				orders =>{
					this.orders=orders;
				},
				error =>  console.error(error)
			);
		});
	}
}