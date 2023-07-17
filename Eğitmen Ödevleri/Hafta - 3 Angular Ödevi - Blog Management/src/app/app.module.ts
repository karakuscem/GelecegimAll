import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import { TableComponent } from './table/table.component';
import { UserModule } from './user/user.module';
import { PostListModule } from './post-list/post-list.module';
import { CategoryModule } from './category/category.module';
import { CommentModule } from './comment/comment.module';
import { FilterComponent } from './filter/filter.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    TableComponent,
    FilterComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [TableComponent, AppRoutingModule, FilterComponent]
})
export class AppModule { }
