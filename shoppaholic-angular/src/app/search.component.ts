import { Component } from '@angular/core';
import { Http } from '@angular/http';

@Component({
    selector: 'search',
    templateUrl: './search.component.html'
  })
  export class SearchComponent {
/* ejemplo10 buscar libros en google

 private books: string[] = [];

  constructor(private http: Http) { }

  search(title: string) {

    this.books = [];

    let url = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + title;

    this.http.get(url).subscribe(
      response => {
        let data = response.json();
        for (var i = 0; i < data.items.length; i++) {
          let bookTitle = data.items[i].volumeInfo.title;
          this.books.push(bookTitle);
        }
      },
      error => console.error(error)
    );
  }





*/



}