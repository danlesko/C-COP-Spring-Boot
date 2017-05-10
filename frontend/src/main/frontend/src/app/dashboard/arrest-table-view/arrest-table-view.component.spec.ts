// Template code

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArrestTableViewComponent } from './arrest-table-view.component';

describe('ArrestTableViewComponent', () => {
  let component: ArrestTableViewComponent;
  let fixture: ComponentFixture<ArrestTableViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArrestTableViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArrestTableViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
