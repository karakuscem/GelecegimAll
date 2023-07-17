import { Component } from '@angular/core';
import { Post } from '../post';
import { PostService } from '../post.service';
import { Router, ActivatedRoute, Params  } from '@angular/router';
import { CommentService } from 'src/app/comment/comment.service';


@Component({
  selector: 'app-post-list-page',
  templateUrl: './post-list-page.component.html',
  styleUrls: ['./post-list-page.component.css']
})
export class PostListPageComponent {
  // Tablo için gerekli değişkenler
  columns: string[] = ['POST ID', 'TITLE', 'VIEW', 'DATE', 'PUBLISHED', 'EDIT'];
  data: Post[] = [];
  // Filtreleme için gerekli değişkenler
  filterOptions: string[] = ["postId", "userId", "categoryId"];
  // Two-way binding için gerekli değişkenler
  postId: number = 0;
  title: string = '';
  view: number = 0;
  date: string = '';
  published: boolean = false;
  placeHolderTitle: string = '';

  // Servislerin inject edilmesi ve ilk verilerin çekilmesi
  constructor(
    private postService: PostService,
    private router: Router,
    private route: ActivatedRoute,
    private commentService: CommentService
    ) {
    this.data = this.postService.getPosts();
    if (this.data.length === 0) {
      this.postService.setPosts();
      this.data = this.postService.getPosts();
    }
  }

  // Sayfa yenilendiğinde query paramslar kontrol edilir ve filtreleme yapılır
  ngOnInit() {
    this.route.queryParams.subscribe((params: Params) => {
      const postId = params['postId'];
      const userId = params['userId'];
      const categoryId = params['categoryId'];
      this.data = this.postService.getPosts();

      if (postId) {
        this.data = this.data.filter(post => post.POSTID === Number(postId));
      }
      if (userId) {
        this.data = this.data.filter(post => post.USERID === Number(userId));
      }
      if (categoryId) {
        this.data = this.data.filter(post => post.CATEGORYID === Number(categoryId));
      }
    });
  }

  // Tablodaki butonlara tıklanıldığında çalışan fonksiyonlar
  handleDeleteClick($event: number): void {
    if (this.commentService.getCommentsByPostID(Number($event)).length > 0)
      alert('You cannot delete a post with comments!');
    else if (confirm('Are you sure you want to delete this post?'))
    {
      this.postService.deletePost(Number($event));
      this.data = this.postService.getPosts();
      this.clearFilter();
    }
  }

  handleDetailClick($event: number): void {
    this.postId = Number($event);
    this.router.navigate(['/post-list/', this.postId]);
  }

  // Filtreleme için gerekli fonksiyonlar
  applyFilter(obj: any): void {
    if (obj.filterBy === 'postId') {
      this.router.navigate(['/post-list'], { queryParams: { postId: obj.filterValue } });
    }
    else if (obj.filterBy === 'userId') {
      this.router.navigate(['/post-list'], { queryParams: { userId: obj.filterValue } });
    }
    else if (obj.filterBy === 'categoryId') {
      this.router.navigate(['/post-list'], { queryParams: { categoryId: obj.filterValue } });
    }
  }

  clearFilter(): void {
    this.data = this.postService.getPosts();
    this.router.navigate(['/post-list']);
  }
}
