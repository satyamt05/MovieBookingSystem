import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddtheatreComponent } from './addtheatre.component';

describe('AddtheatreComponent', () => {
  let component: AddtheatreComponent;
  let fixture: ComponentFixture<AddtheatreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddtheatreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddtheatreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
