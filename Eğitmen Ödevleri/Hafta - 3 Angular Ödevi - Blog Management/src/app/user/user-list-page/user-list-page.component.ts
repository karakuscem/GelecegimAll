import { Component } from '@angular/core';
import { User } from '../user';
import { UserManagementService } from '../user-management.service';
import { PostService } from 'src/app/post-list/post.service';
import { CommentService } from 'src/app/comment/comment.service';
import { Post } from 'src/app/post-list/post';
import { Comment } from 'src/app/comment/comment';
import { Router, ActivatedRoute, Params } from '@angular/router';
@Component({
  selector: 'app-user-list-page',
  templateUrl: './user-list-page.component.html',
  styleUrls: ['./user-list-page.component.css']
})
export class UserListPageComponent {
  columns: string[] = ['ID', 'USERNAME', 'EMAIL', 'DATE', 'ACTIVE', 'EDIT'];
  data: User[] = [];
  filterOptions: string[] = ['userId', 'active'];
  editMode: boolean = false;
  userId: number = 0;
  username: string = '';
  email: string = '';
  date: string = '';
  active: boolean = false;
  placeHolderUsername: string = '';
  placeHolderEmail: string = '';

  // Servislerin inject edilmesi ve ilk verilerin çekilmesi
  constructor(
    private userService: UserManagementService,
    private postService: PostService,
    private commentService: CommentService,
    private Router: Router,
    private ActivatedRoute: ActivatedRoute
    ) {
    this.data = this.userService.getUsers();
    if (this.data.length === 0) {
      this.userService.setUsers();
      this.data = this.userService.getUsers();
    }
  }

  // Sayfa yenilendiğinde query paramslar kontrol edilir ve filtreleme yapılır
  ngOnInit() {
    this.ActivatedRoute.queryParams.subscribe((params: Params) => {
      const userId = params['userId'];
      const active = params['active'];
      this.data = this.userService.getUsers();

      if (userId) {
        this.data = this.data.filter(user => Number(user.ID) === Number(userId));
      }
      if (active) {
        this.data = this.data.filter(user => Number(user.ACTIVE) === Number(active));
      }
    });
  }

  // Delete'e tıklanınca verilen id'ye sahip user silinir
  handleDeleteClick($event: number): void {
    if (this.data.length === 1)
      alert('You cannot delete the last user!');
    else if (this.postService.getPostsByUserID(Number($event)).length > 0)
      alert('You cannot delete a user with posts!');
    else if (this.commentService.getCommentsByUserID(Number($event)).length > 0)
      alert('You cannot delete a user with comments!');
    else if (confirm('Are you sure you want to delete this user?'))
    {
      this.userService.deleteUser(Number($event));
      this.data = this.userService.getUsers();
    }

  }

  // Edit'e tıklanınca form gösterilir, verilen id değişkende tutulur
  handleEditClick($event: number): void {
    this.editMode = true;
    this.userId = Number($event);
    this.placeHolderUsername = this.userService.getUserByID(this.userId)!.USERNAME.toUpperCase();
    this.placeHolderEmail = this.userService.getUserByID(this.userId)!.EMAIL.toUpperCase();
  }

  // Cancel'a tıklandığında form temizlenir ve kapatılır
  handleCancelClick(): void {
    this.userId = 0;
    this.username = '';
    this.email = '';
    this.date = '';
    this.active = false;
    this.editMode = false;
  }

  // Save'e tıklandığında formdaki veriler kontrol edilir ve güncelleme yapılır
  handleSaveClick(): void {
    if (this.username === '' || this.email === '' || this.date === '')
      alert('Please fill out all fields!');
    else if (this.userService.checkUnique(this.username, this.email, this.userId) === false)
      alert('Username or email already exists!');
    else {
      this.date = new Date(this.date).toLocaleDateString();
      this.userService.updateUser(this.userId, this.username, this.email, this.date, this.active);
      this.data = this.userService.getUsers();
      this.editMode = false;
      this.handleCancelClick();
    }
  }

  // Filtre fonksiyonları
  applyFilter(obj: any) {
   if (obj.filterBy === 'userId')
      this.Router.navigate(['/user-list-page'], { queryParams: { userId: obj.filterValue } });
    else if (obj.filterBy === 'active')
      this.Router.navigate(['/user-list-page'], { queryParams: { active: obj.filterValue } });
  }

  clearFilter() {
    this.data = this.userService.getUsers();
    this.Router.navigate(['/user-list-page']);
  }
}
