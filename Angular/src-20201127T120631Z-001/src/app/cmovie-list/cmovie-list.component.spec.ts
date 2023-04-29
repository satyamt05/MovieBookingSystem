import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CmovieListComponent } from './cmovie-list.component';

describe('CmovieListComponent', () => {
  let component: CmovieListComponent;
  let fixture: ComponentFixture<CmovieListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CmovieListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CmovieListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
