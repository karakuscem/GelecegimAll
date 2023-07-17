import { Injectable } from '@angular/core';
import { Post } from './post';
import { postsInfo } from 'src/assets/default-posts';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private posts: Post[] = [];
  // Postları local storage'dan getirir
  getPosts(): Post[] {
    if (localStorage.getItem('posts') !== null) {
      this.posts = JSON.parse(localStorage.getItem('posts') || '{}');
    } else {
      this.setPosts();
    }
    return this.posts;
  }
  // Postları local storage'a kaydeder
  setPosts(): void {
    this.posts = postsInfo;
    localStorage.setItem('posts', JSON.stringify(this.posts));
  }
  // Post siler
  deletePost(id: number): void {
    this.posts = this.posts.filter(post => post.POSTID !== id);
    localStorage.setItem('posts', JSON.stringify(this.posts));
  }
  // Post id'sine göre post getirir
  getPostById(id: number): Post | undefined {
    return this.posts.find(post => post.POSTID === id);
  }
  // Post başlığına göre post getirir
  getPostByTitle(title: string): Post | undefined {
    return this.posts.find(post => post.TITLE.toLowerCase() === title.toLowerCase());
  }
  // Kullanıcıya ait postları getirir
  getPostsByUserID(id: number): Post[] {
    this.posts = this.getPosts();
    return this.posts.filter(post => Number(post.USERID) === id);
  }
  // Post günceller
  updatePost(postObj: Post): void {
    this.posts = this.posts.map(post => {
      if (Number(post.POSTID) === Number(postObj.POSTID)) {
        post = postObj;
      }
      return post;
    });
    localStorage.setItem('posts', JSON.stringify(this.posts));
  }
  // Post ekler
  addPost(post: Post): void {
    const posts = this.getPosts();
    posts.push(post);
    localStorage.setItem('posts', JSON.stringify(posts));
  }

}
