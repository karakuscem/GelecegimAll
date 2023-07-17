import { Component } from '@angular/core';
import { Category } from '../category';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../category.service';
import { PostService } from 'src/app/post-list/post.service';

@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.css']
})
export class CategoryDetailComponent {
  categories: Category[] = [];
  categoryObj: Category = {
    CATEGORYID: 0,
    NAME: '',
    DATE: ''
  }
  postCount: Number = 0;
  popularityNumber: Number = 0;

  constructor(
    private CategoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router,
    private postService: PostService,
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      const id = params['id'];
      this.postCount = this.CategoryService.postCount(Number(id));
      this.categories = this.CategoryService.getCategories();
      this.categoryObj = this.CategoryService.getCategoryById(Number(id))!;
      this.popularityNumber = this.CategoryService.getCategoryRanking(Number(id));
    })
  }
  // Kategori silinir
  handleDeleteClick($event: number): void {
    if (this.CategoryService.getCategories().length === 1)
      alert('You cannot delete the last category!');
    else if (this.CategoryService.postCount(Number($event)) > 0)
      alert('You cannot delete a category that has posts!');
    else if (confirm('Are you sure you want to delete this category?'))
    {
      this.CategoryService.deleteCategory(Number($event));
      this.categories = this.CategoryService.getCategories();
    }
  }
  // Kategori güncellenir
  handleSeePostsClick($event: number): void {
    this.router.navigateByUrl('/post-list?categoryId=' + $event);
  }
}
