
import { Injectable, OnInit } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import {Customer} from './customer.model';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";

const URL = '/api';


@Injectable()
export class CustomerService {

    isLogged = false;
    isAdmin = false;
    customer: Customer;

    constructor(private http: Http,private router: Router) {
        //this.reqIsLogged();
    }

    reqIsLogged() {

        const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });


        const options = new RequestOptions({ withCredentials: true, headers});

        this.http.get(URL + '/logIn',options).subscribe(
            response => this.processLogInResponse(response),
            error => {
                if (error.status !== 401) {
                    console.error('Error when asking if logged: ' +
                        JSON.stringify(error));
                }
            }
        );
    }

    private processLogInResponse(response) {
        this.isLogged = true;
        this.customer = response.json();
       
    }

    logIn(email: string, password: string) {
        
        const userPass = email + ':' + password;
        var s =  utf8_to_b64(userPass);
        const headers = new Headers({
            //'Access-Control-Allow-Origin': '*',

            'Authorization': 'Basic ' + btoa(userPass),
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({ withCredentials: true, headers });

        return this.http.get(URL + '/login', options).map(
            response => {
                this.processLogInResponse(response);
                return this.customer;
            }
        );
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
    getCustomer(id:number){
	    let url="http://localhost:4200/api/customer/"+id;
	    console.log(url);
	    
	    return this.http.get(url).map(
	      response => response.json())
	      .catch(error =>this.handleError(error))
 	 }
 	getCustomerByName(name:string){
    	let url="http://localhost:4200/api/User/SearchByName?key="+name;
    	console.log(url);
    
   		 return this.http.get(url).map(
      	response => response.json())
      .catch(error =>this.handleError(error))
  }

  createCustomer(user:Customer){
    let url = "http://localhost:4200/api/register";
    return this.http.post(url,user)
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