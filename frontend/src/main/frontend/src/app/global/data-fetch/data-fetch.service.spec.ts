import { TestBed, inject } from '@angular/core/testing';

import { DataFetchService } from './data-fetch.service';

describe('DataFetchService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DataFetchService]
    });
  });

  it('should ...', inject([DataFetchService], (service: DataFetchService) => {
    expect(service).toBeTruthy();
  }));
});
