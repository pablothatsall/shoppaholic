
import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Pedido } from './pedido.model';
import { Customer } from './customer.model';




@Injectable()
export class CustomerService {


    isLogged = false;
    isAdmin = false;
    customer: Customer;

   constructor(private http: Http) { };

      getCustomer(id:number){
      	 return this.http.get("http://localhost:4200/api/customer/"+id, { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
      
    }


  logIn(email: string, pass: string) {
        
        const userPass = email + ':' + pass;

        const headers = new Headers({
            //'Access-Control-Allow-Origin': '*',
            'Authorization': 'Basic ' + utf8_to_b64(userPass),
            'X-Requested-With': 'XMLHttpRequest'
        });}

   private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }

logOut() {
        //this.reqIsLogged();
        //return this.http.get('https://localhost:8443/api' + '/logOut', { withCredentials: true}).map(
            return this.http.get(URL + '/logOut', { withCredentials: true}).map(
            response => {
                this.isLogged = false;
                this.isAdmin = false;
                this.customer=null;
                return response;
            }
        );
    }
}

function utf8_to_b64(str) {
    return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, function (match, p1) {
        return String.fromCharCode(<any>'0x' + p1);
    }));

}
