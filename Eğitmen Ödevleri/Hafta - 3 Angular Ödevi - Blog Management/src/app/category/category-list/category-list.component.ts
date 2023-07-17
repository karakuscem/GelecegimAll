import { Component } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { Router } from '@angular/router';
import { PostService } from 'src/app/post-list/post.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent {
  columns: string[] = ["CATEGORYID", "NAME", "DATE", "EDIT"];
  data: Category[] = [];
  editMode: Boolean = false;
  categoryId: number = 0;
  categoryName: string = '';
  date: string = '';

  constructor(
    private CategoryService: CategoryService,
    private Router: Router
    ){
    this.data = this.CategoryService.getCategories();
  }
  // Delete'e tıklanınca ilgili kategori silinir
  handleDeleteClick($event: number): void {
    if (this.CategoryService.getCategories().length === 1)
      alert('You cannot delete the last category!');
    else if (this.CategoryService.postCount(Number($event)) > 0)
      alert('You cannot delete a category that has posts!');
    else if (confirm('Are you sure you want to delete this category?'))
    {
      this.CategoryService.deleteCategory(Number($event));
      this.data = this.CategoryService.getCategories();
    }
  }
  // Edit'e tıklanınca editMode açılır ve inputlara verileri aktarılır
  handleEditClick($event: number): void {
    this.editMode = !this.editMode;
    this.categoryId = $event;
  }
   // Edit'e tıklanınca editMode açılır ve inputlara verileri aktarılır
  handleDetailClick($event: number): void {
    this.categoryId = Number($event);
    this.Router.navigate(['/category-list/', this.categoryId]);
  }
  // Cancel'a tıklanınca editMode kapatılır ve inputlar temizlenir
  handleCancelClick(): void {
    this.categoryId = 0;
    this.categoryName = '';
    this.date = '';
    this.editMode = false;
  }
  // Save'e tıklanınca verilen id'ye sahip user güncellenir
  handleSaveClick(): void {
    if (!this.CategoryService.checkUnique(this.categoryName, this.categoryId)) {
      alert('This category name is already taken!');
    } else {
      this.CategoryService.editCategory(Number(this.categoryId), this.categoryName, this.date)
      this.data = this.CategoryService.getCategories();
      this.handleCancelClick();
    }
  }
}
