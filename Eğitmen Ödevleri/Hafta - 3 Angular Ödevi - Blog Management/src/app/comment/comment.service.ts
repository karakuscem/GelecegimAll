import { Injectable } from '@angular/core';
import { Comment } from './comment';
import { commentsInfo } from 'src/assets/default-comments';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private comments: Comment[] = [];
  // Yorumları getir
  getComments(): Comment[] {
    if (localStorage.getItem('comments') !== null) {
      this.comments = JSON.parse(localStorage.getItem('comments') || '{}');
    } else {
      this.setComments();
    }
    return this.comments;
  }
  // Yorumları ayarla
  setComments(): void {
    this.comments = commentsInfo;
    localStorage.setItem('comments', JSON.stringify(this.comments));
  }
  // Yorum sil
  deleteComment(id: number): void {
    this.comments = this.comments.filter(comment => comment.COMMENTID !== id);
    localStorage.setItem('comments', JSON.stringify(this.comments));
  }
  // Yorum id ile getir
  getCommentById(id: number): Comment {
    return this.comments.find(comment => comment.COMMENTID === id)!;
  }
  // Yorum kullanıcı id ile getir
  getCommentsByUserID(id: number): Comment[] {
    this.comments = this.getComments();
    return this.comments.filter(comment => Number(comment.USERID) === Number(id));
  }
  // Yorum post id ile getir
  getCommentsByPostID(id: number): Comment[] {
    this.comments = this.getComments();
    return this.comments.filter(comment => Number(comment.POSTID) === Number(id));
  }
  // Yorum güncelle
  updateComment(commentObj: Comment): void {
    this.comments = this.comments.map(comment => {
      if (comment.COMMENTID === commentObj.COMMENTID) {
        comment = commentObj;
      }
      return comment;
    });
    localStorage.setItem('comments', JSON.stringify(this.comments));
  }
  // Yorum ekle
  addComment(commentObj: Comment): void {
    this.comments.push(commentObj);
    localStorage.setItem('comments', JSON.stringify(this.comments));
  }
}
