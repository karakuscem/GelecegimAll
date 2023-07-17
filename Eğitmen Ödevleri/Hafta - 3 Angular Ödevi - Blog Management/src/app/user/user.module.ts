import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListPageComponent } from './user-list-page/user-list-page.component';
import { AppModule } from '../app.module';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { UserAddComponent } from './user-add/user-add.component';





@NgModule({
  declarations: [
    UserListPageComponent,
    UserAddComponent,
  ],
  imports: [
    CommonModule,
    AppModule,
    FormsModule,
  ],
  exports: [UserListPageComponent]
})
export class UserModule { }
