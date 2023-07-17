import { Component } from '@angular/core';
import { PostService } from '../post.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../post';
import { User } from 'src/app/user/user';
import { UserManagementService } from 'src/app/user/user-management.service';
import { CategoryService } from 'src/app/category/category.service';
import { Category } from 'src/app/category/category';
import { CommentService } from 'src/app/comment/comment.service';
import { Comment } from 'src/app/comment/comment';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent {
  // Servisten gelen datalar için gerekli değişkenler
  posts: Post[] = [];
  users: User[] = [];
  categories: Category[] = [];
  comments: Comment[] = [];
  userComments: Comment[] = [];
  // Post objesi
  postObj: Post = {
    POSTID: 0,
    TITLE: '',
    VIEW: 0,
    DATE: '',
    PUBLISHED: false,
    USERID: 0,
    CATEGORYID: 0,
    CONTENT: ''
  };
  // Postun yazarı ve kategorisi için gerekli değişkenler
  author: string = '';
  category: string = '';
  editMode: boolean = false;

  // Servislerin ve route'un inject edilmesi
  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private userManagementService: UserManagementService,
    private categoryService: CategoryService,
    private Router: Router,
    private commentService: CommentService
    ) { }

  // Params'dan gelen id'ye göre post, yazar ve kategori bilgilerinin alınması
  ngOnInit() {
    this.route.params.subscribe(params => {
      const id = params['id'];
      this.posts = this.postService.getPosts();
      this.categories = this.categoryService.getCategories();
      this.users = this.userManagementService.getUsers();
      this.comments = this.commentService.getComments();
      this.postObj = this.posts.find(post => post.POSTID === Number(id))!;
      this.author = this.users.find(user => user.ID === Number(this.postObj.USERID))!.USERNAME;
      this.category = this.categories.find(category => category.CATEGORYID === Number(this.postObj.CATEGORYID))!.NAME;
      this.userComments = this.commentService.getCommentsByPostID(Number(this.postObj.POSTID));
    });
  }

  // Edit mode'un açılması ve kapatılması
  editPost(): void {
    this.editMode = !this.editMode;
  }

  // Post'un silinmesi
  deletePost(): void {
    if (this.commentService.getCommentsByPostID(Number(this.postObj.POSTID)).length > 0)
      alert('You cannot delete a post with comments!');
    if (confirm('Are you sure you want to delete this post?'))
    {
      this.postService.deletePost(this.postObj.POSTID);
      this.Router.navigate(['/post-list']);
    }
  }

  // Post'un güncellenmesi
  updatePost(): void {
    this.postObj.POSTID = Number(this.postObj.POSTID);
    this.postObj.CATEGORYID = Number(this.postObj.CATEGORYID);
    this.postObj.USERID = Number(this.postObj.USERID);
    this.postObj.DATE = new Date(this.postObj.DATE).toLocaleDateString();
    this.postService.updatePost(this.postObj);
    this.author = this.users.find(user => user.ID === Number(this.postObj.USERID))!.USERNAME;
    this.editMode = false;
    this.Router.navigate(['/post-list']);
  }
}
