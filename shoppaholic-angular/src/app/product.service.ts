
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Comment } from './comment.model';



@Injectable()
export class ProductService {
   constructor(private http: Http) { };

      getProduct(id:number){
      let url="http://localhost:4200/api/Product/"+id;
       console.log(url);
    
    return this.http.get(url).map(
      response => response.json())
      //response => this.extractPlaylist(response))
      .catch(error =>this.handleError(error))
    }

    getProducts(){
    let url="http://localhost:4200/api/searchlabel/Videogames/1";
    const options = new RequestOptions({ withCredentials: true});
    return this.http.get(url,options).map(
      response => response.json())
      .catch(error =>this.handleError(error))
  }

  private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }

}
