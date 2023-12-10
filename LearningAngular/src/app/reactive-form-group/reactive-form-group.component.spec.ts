import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactiveFormGroupComponent } from './reactive-form-group.component';

describe('ReactiveFormGroupComponent', () => {
  let component: ReactiveFormGroupComponent;
  let fixture: ComponentFixture<ReactiveFormGroupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReactiveFormGroupComponent]
    });
    fixture = TestBed.createComponent(ReactiveFormGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
