import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchscreenComponent } from './searchscreen.component';

describe('SearchscreenComponent', () => {
  let component: SearchscreenComponent;
  let fixture: ComponentFixture<SearchscreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchscreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchscreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
