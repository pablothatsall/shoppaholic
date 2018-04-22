
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Product } from './product.model';
import { Customer } from './customer.model';
import { CustomerService } from './customer.service';




@Injectable()
export class PedidoService {
   constructor(private http: Http, ) { };

      getPedido(id:number){
     





    const options = new RequestOptions({ withCredentials: true });

      return this.http.get('http://localhost:4200/api/order/' + id, options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
    }

     getCart(id:number|string, customer:Customer){
	const userPass = customer.mail + ':' + customer.password;

        const headers = new Headers({
            //'Access-Control-Allow-Origin': '*',
              'Authorization': 'Basic ' + btoa(userPass),
            'X-Requested-With': 'XMLHttpRequest'
        });





    const options = new RequestOptions({ withCredentials: true });

      return this.http.get('http://localhost:4200/api/customer/cart/' + id, options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
    }

     payCart(){
  const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });


        const options = new RequestOptions({ withCredentials: true, headers});




    

      return this.http.post('http://localhost:4200/api/paycart/', options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
    }
    private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }


}
function utf8_to_b64(str) {
    return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, function (match, p1) {
        return String.fromCharCode(<any>'0x' + p1);
    }));
}
