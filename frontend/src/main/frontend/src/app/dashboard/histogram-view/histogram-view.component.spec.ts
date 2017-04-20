import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HistogramViewComponent } from './histogram-view.component';

describe('HistogramViewComponent', () => {
  let component: HistogramViewComponent;
  let fixture: ComponentFixture<HistogramViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HistogramViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HistogramViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
