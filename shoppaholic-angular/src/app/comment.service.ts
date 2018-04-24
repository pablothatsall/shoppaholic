
import { Injectable } from '@angular/core';
import { Http, Response,RequestOptions,Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from "rxjs/Observable";
import { Comment } from './comment.model';


@Injectable()
export class CommentService {
   constructor(private http: Http) { };




      getComments(id:number|string){
      return this.http.get('/api/comments/' + id)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  }


      addComments(id:number|string, comment:Comment){



        const options = new RequestOptions({ withCredentials: true});
         this.http.get('/api/product/' + id,options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
      return this.http.post('/api/newcomment/' + id,comment,options)
      .map(response => response.json())
      .catch(error => this.handleError(error));

  }




   

 private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text);
    }
}
