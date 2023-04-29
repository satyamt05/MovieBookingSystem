import { TestBed } from '@angular/core/testing';

import { TheatreserviceService } from './theatreservice.service';

describe('TheatreserviceService', () => {
  let service: TheatreserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TheatreserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
