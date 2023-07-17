import { Component } from '@angular/core';
import { UserManagementService } from '../user-management.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent {
  // Two-way binding için gerekli değişkenler
  username: string = '';
  email: string = '';
  isActive: boolean = true;
  date: string = '';
  isSubmitted: boolean = false;
  isCancel: boolean = false;

  // Servislerin inject edilmesi
  constructor(private userService: UserManagementService, private router: Router) { }

  // Add butonuna tıklanınca yeni user eklenir
  handleAddUser(): void {
    if (this.username === '' || this.email === '' || this.date === '')
      alert('Please fill out all fields!');
    else if (this.userService.getUserByUsername(this.username) !== undefined)
      alert('Username already exists!');
    else if (this.userService.getUserByEmail(this.email) !== undefined)
      alert('Email already exists!');
    else
    {
      this.date = new Date(this.date).toLocaleDateString();
      this.userService.addUser(this.username, this.email, this.isActive, this.date);
      this.isSubmitted = true;
      setTimeout(() => {
        this.isSubmitted = false;
        this.router.navigateByUrl('/user-list-page');
      }, 2000);
    }
  }

  // Cancel butonuna tıklanınca user list sayfasına yönlendirilir
  handleCancel(): void {
    this.isCancel = true;
    setTimeout(() => {
      this.isCancel = false;
      this.router.navigateByUrl('/user-list-page');
    }, 2000);
  }
}
