import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ArticleService } from './article.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  boites : string;

  constructor(private articleService: ArticleService) {

  }

  onSubmit(form: NgForm) {
    const articles = form.value['articles'];
    this.articleService.addArticles(articles);
  }

  onValidatee(){
   this.boites = this.articleService.getBoxes();
  }


  ngOnInit() {
  }

}

