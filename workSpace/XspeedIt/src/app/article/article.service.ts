import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private apiUrl = '/api/articles';

  constructor(private http: HttpClient) {  }

  public  box ;

  getBoxes() {
    this.http
      .get<any>(this.apiUrl)
      .subscribe(
        (response) => {
          this.box = response;
          this.box = this.box.name;
        }
      );
    return this.box;
  }


  addArticles(articles: string ): Promise<Array<any>> {
    const articlesObject = {
      name: ''
    };
    articlesObject.name = articles;
    const empHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.apiUrl, JSON.stringify(articlesObject), { headers: empHeaders })
    .toPromise()
    .then(response => response as any[])
    .catch(this.handleError);
  }


  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
    }

}
