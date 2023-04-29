import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewtheatreComponent } from './viewtheatre.component';

describe('ViewtheatreComponent', () => {
  let component: ViewtheatreComponent;
  let fixture: ComponentFixture<ViewtheatreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewtheatreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewtheatreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
