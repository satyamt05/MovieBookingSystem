import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatescreenComponent } from './updatescreen.component';

describe('UpdatescreenComponent', () => {
  let component: UpdatescreenComponent;
  let fixture: ComponentFixture<UpdatescreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatescreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatescreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
