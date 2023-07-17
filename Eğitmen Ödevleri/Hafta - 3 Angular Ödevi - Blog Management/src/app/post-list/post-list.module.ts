import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostListPageComponent } from './post-list-page/post-list-page.component';
import { AppModule } from '../app.module';
import { FormsModule } from '@angular/forms';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { PostAddComponent } from './post-add/post-add.component';

@NgModule({
  declarations: [
    PostListPageComponent,
    PostDetailComponent,
    PostAddComponent
  ],
  imports: [
    CommonModule,
    AppModule,
    FormsModule
  ]
})
export class PostListModule { }
