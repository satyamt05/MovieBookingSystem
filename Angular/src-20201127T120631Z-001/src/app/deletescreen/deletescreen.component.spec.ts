import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletescreenComponent } from './deletescreen.component';

describe('DeletescreenComponent', () => {
  let component: DeletescreenComponent;
  let fixture: ComponentFixture<DeletescreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletescreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletescreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
