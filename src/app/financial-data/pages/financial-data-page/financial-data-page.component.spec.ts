import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancialDataPageComponent } from './financial-data-page.component';

describe('FinancialDataPageComponent', () => {
  let component: FinancialDataPageComponent;
  let fixture: ComponentFixture<FinancialDataPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FinancialDataPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FinancialDataPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
