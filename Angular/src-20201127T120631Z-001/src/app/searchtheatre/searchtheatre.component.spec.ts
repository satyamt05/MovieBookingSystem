import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchtheatreComponent } from './searchtheatre.component';

describe('SearchtheatreComponent', () => {
  let component: SearchtheatreComponent;
  let fixture: ComponentFixture<SearchtheatreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchtheatreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchtheatreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
