
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Product } from './product.model';



@Injectable()
export class PedidoService {
   constructor(private http: Http) { };

      getPedido(id:number){
      let url="http://localhost:4200/api/order/"+id;
    }

     getCart(id:number|string){
     	 const headers = new Headers({
      'Content-Type': 'application/json',
      //'X-Requested-With': 'XMLHttpRequest'
    });

    const options = new RequestOptions({ withCredentials: true, headers });

      return this.http.get('http://localhost:4200/api/customer/cart/' + id, options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
    }
    private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }


}
