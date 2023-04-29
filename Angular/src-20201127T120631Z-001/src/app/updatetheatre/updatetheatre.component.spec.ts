import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatetheatreComponent } from './updatetheatre.component';

describe('UpdatetheatreComponent', () => {
  let component: UpdatetheatreComponent;
  let fixture: ComponentFixture<UpdatetheatreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatetheatreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatetheatreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
