import { Component } from '@angular/core';
import { Comment } from '../comment';
import { CommentService } from '../comment.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent {
  // Tablo için kolon başlıkları
  columns: string[] = ['COMMENT ID', 'COMMENT', 'DATE', 'CONFIRMED', 'EDIT'];
  data: Comment[] = [];
  // Filtreleme seçenekleri
  filterOptions: string[] = ['postId', 'confirmed'];

  // Servislerin inject edilmesi ve ilk verilerin çekilmesi
  constructor(
    private commentService: CommentService,
    private Router: Router,
    private ActivatedRoute: ActivatedRoute,
    ) {
    this.data = this.commentService.getComments();
  }

  // Sayfa yenilendiğinde query paramslar kontrol edilir ve filtreleme yapılır
  ngOnInit() {
    this.ActivatedRoute.queryParams.subscribe(params => {
      const postId = params['postId'];
      const confirmed = params['confirmed'];
      this.data = this.commentService.getComments();

      if (postId) {
        this.data = this.data.filter(comment => comment.POSTID === Number(postId));
      }
      if (confirmed) {
        this.data = this.data.filter(comment =>  Number(comment.CONFIRMED) === Number(confirmed));
      }
    });
  }

  // Filtreleme yapılması
  applyFilter(obj: any) {
    if (obj.filterBy === 'postId') {
      this.Router.navigate(['/comment-list'], { queryParams: { postId: obj.filterValue } });
    }
    else if (obj.filterBy === 'confirmed') {
      this.Router.navigate(['/comment-list'], { queryParams: { confirmed: obj.filterValue } });
    }
  }

  // Filtreleme alanlarının temizlenmesi
  clearFilter() {
    this.data = this.commentService.getComments();
    this.Router.navigate(['/comment-list']);
  }

  // Delete butonuna basıldığında çalışır ve ilgili commenti siler
  handleDeleteClick($event: number) {
    if (confirm('Are you sure you want to delete this comment?')) {
      this.commentService.deleteComment(Number($event));
      this.data = this.commentService.getComments();
    }
  }

  // Detail butonuna basıldığında çalışır ve ilgili commentin detay sayfasına yönlendirir
  handleDetailClick($event: number) {
    this.Router.navigate(['/comment-list', $event]);
  }
}
