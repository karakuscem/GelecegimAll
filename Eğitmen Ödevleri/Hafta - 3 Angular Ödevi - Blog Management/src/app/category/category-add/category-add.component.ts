import { Component } from '@angular/core';
import { CategoryService } from '../category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent {
  name: string = '';
  date: string = '';

  constructor(
    private categoryService: CategoryService,
    private router: Router
  ) {}
  // 
  addCategory(): void {
    if (this.name === '' || this.date === '')
      alert('Please fill in all fields!');
    else if (this.categoryService.checkUnique(this.name, 0) === false)
      alert('This category already exists!');
    else
    {
      this.categoryService.addCategory(this.name, this.date);
      this.router.navigate(['/category-list']);
    }
  }

  cancel(): void {
    this.router.navigate(['/category-list']);
  }
}
