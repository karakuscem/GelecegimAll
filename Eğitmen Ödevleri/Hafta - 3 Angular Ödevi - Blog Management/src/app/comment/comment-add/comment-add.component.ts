import { Component } from '@angular/core';
import { Post } from 'src/app/post-list/post';
import { User } from 'src/app/user/user';
import { CommentService } from '../comment.service';
import { UserManagementService } from 'src/app/user/user-management.service';
import { Router } from '@angular/router';
import { PostService } from 'src/app/post-list/post.service';

@Component({
  selector: 'app-comment-add',
  templateUrl: './comment-add.component.html',
  styleUrls: ['./comment-add.component.css']
})
export class CommentAddComponent {
  date: string = '';
  confirmed: boolean = false;
  userId: number = 0;
  users: User[] = [];
  postId: number = 0;
  posts: Post[] = [];
  comment: string = '';

  constructor(
    private commentService: CommentService,
    private userManagementService: UserManagementService,
    private postService: PostService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // User ve post listesi alınır
    this.users = this.userManagementService.getUsers();
    this.posts = this.postService.getPosts();
  }
  // Add butonuna tıklanınca yeni user eklenir
  addComment(): void {
    if (this.date === '' || this.userId === 0 || this.postId === 0 || this.comment === '')
      alert('Please fill in all fields!');
    else
    {
      const id = this.commentService.getComments()[this.commentService.getComments().length - 1].COMMENTID + 1;
      const newComment = {
        COMMENTID: id,
        COMMENT: this.comment,
        DATE: new Date(this.date).toLocaleDateString(),
        CONFIRMED: Boolean(this.confirmed),
        USERID: Number(this.userId),
        POSTID: Number(this.postId),
      };
      this.commentService.addComment(newComment);
      this.router.navigate(['/comment-list']);
    }
  }
  // Cancel butonuna tıklanınca comment listesine geri dönülür
  cancel(): void {
    this.router.navigate(['/comment-list']);
  }
}
