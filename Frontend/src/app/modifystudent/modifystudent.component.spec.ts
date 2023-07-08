import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifystudentComponent } from './modifystudent.component';

describe('ModifystudentComponent', () => {
  let component: ModifystudentComponent;
  let fixture: ComponentFixture<ModifystudentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifystudentComponent]
    });
    fixture = TestBed.createComponent(ModifystudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
