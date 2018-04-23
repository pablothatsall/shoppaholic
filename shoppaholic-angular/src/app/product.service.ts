
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Comment } from './comment.model';
import { Product } from './product.model';
import {CustomerService} from './customer.service';
import {PedidoService} from './pedido.service';


const URL = 'http://localhost:4200/api/product/' ;

@Injectable()
export class ProductService {
   constructor(private http: Http) { }

      getProduct(id:number|string){
      return this.http.get(URL + id, { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
    }

    getProducts(){
        const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });

       return this.http.get('http://localhost:4200/api/products', { withCredentials: true, headers })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

   addToCart(id:number|string){
  const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });


        const options = new RequestOptions({ withCredentials: true, headers});
      return this.http.post('http://localhost:4200/api/addToCart/' + id, options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

  addProduct(product:Product){
  const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });


        const options = new RequestOptions({ withCredentials: true, headers});
      return this.http.post('http://localhost:4200/api/admin/newproduct/', product)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }


  editProduct(product:Product, id:number){
  const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });


        const options = new RequestOptions({ withCredentials: true, headers});
      return this.http.put('http://localhost:4200/api/admin/editProduct/'+ id, product)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

  deleteProduct(id:number){
  const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });


        const options = new RequestOptions({ withCredentials: true, headers});
      return this.http.delete('http://localhost:4200/api/admin/deleteProduct/' + id, options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }


   deleteFromCart(id:number|string){
  const headers = new Headers({
          //  'X-Requested-With': 'XMLHttpRequest',
            //'Access-Control-Allow-Origin': '*'
        });


        const options = new RequestOptions({ withCredentials: true, headers});
      return this.http.delete('http://localhost:4200/api/deleteFromCart/' + id)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }


      searchProducts(searchtext:string){
       return this.http.get('http://localhost:4200/api/searchname/' + searchtext + '/1',{ withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  
  }

  private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }



    /*  addToCart(){
    this.pedidoService.addToCart(id).subscribe(
    pedido => {
        
      },
      error => console.error(error)
    )
  }*/
}

