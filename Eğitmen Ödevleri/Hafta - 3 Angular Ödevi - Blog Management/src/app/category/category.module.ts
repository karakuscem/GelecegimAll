import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryListComponent } from './category-list/category-list.component';
import { AppModule } from '../app.module';
import { FormsModule } from '@angular/forms';
import { CategoryDetailComponent } from './category-detail/category-detail.component';
import { UserModule } from '../user/user.module';
import { PostListModule } from '../post-list/post-list.module';
import { CategoryAddComponent } from './category-add/category-add.component';



@NgModule({
  declarations: [
    CategoryListComponent,
    CategoryDetailComponent,
    CategoryAddComponent
  ],
  imports: [
    CommonModule,
    AppModule,
    FormsModule,
  ]
})
export class CategoryModule { }
