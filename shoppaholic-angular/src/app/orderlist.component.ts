import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Http, Response,Headers, RequestOptions } from '@angular/http';
import { CustomerService } from './customer.service';
import {Pedido} from './pedido.model'

@Component({
    selector: 'orderlist',
    templateUrl: './orderlist.component.html'
  })
  export class OrderlistComponent {
  	orders:Pedido[];
}