// Template code

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrimeTableViewComponent } from './crime-table-view.component';

describe('CrimeTableViewComponent', () => {
  let component: CrimeTableViewComponent;
  let fixture: ComponentFixture<CrimeTableViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrimeTableViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrimeTableViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
