import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPayStubsComponent } from './getpaystubs.component';

describe('GetpaystubsComponent', () => {
  let component: GetPayStubsComponent;
  let fixture: ComponentFixture<GetPayStubsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetPayStubsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPayStubsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
