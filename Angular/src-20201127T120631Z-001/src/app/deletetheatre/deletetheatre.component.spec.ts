import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletetheatreComponent } from './deletetheatre.component';

describe('DeletetheatreComponent', () => {
  let component: DeletetheatreComponent;
  let fixture: ComponentFixture<DeletetheatreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletetheatreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletetheatreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
