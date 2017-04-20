import { TestBed, async, inject } from '@angular/core/testing';
import { DatePickerService } from './date-picker.service';

describe('DatePickerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DatePickerService]
    });
  });

  it('should ...', inject([DatePickerService], (service: DatePickerService) => {
    expect(service).toBeTruthy();
  }));
});
