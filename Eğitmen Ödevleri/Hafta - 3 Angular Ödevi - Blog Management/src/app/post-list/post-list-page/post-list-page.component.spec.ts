import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostListPageComponent } from './post-list-page.component';

describe('PostListPageComponent', () => {
  let component: PostListPageComponent;
  let fixture: ComponentFixture<PostListPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostListPageComponent]
    });
    fixture = TestBed.createComponent(PostListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
