import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MdDialog } from '@angular/material';

import { CovalentModule } from '../../../shared/covalent.module';
import { BackendModule } from '../../../shared/backend/backend.module';
import { WaiterCockpitModule } from '../../cockpit.module';

import { WaiterCockpitService } from '../../shared/waiter-cockpit.service';
import { PriceCalculatorService } from '../../../sidenav/shared/price-calculator.service';

import { OrderDialogComponent } from './order-dialog.component';

describe('OrderDialogComponent', () => {
  let component: OrderDialogComponent;
  let dialog: MdDialog;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [ WaiterCockpitService, PriceCalculatorService ],
      imports: [
        BrowserAnimationsModule,
        WaiterCockpitModule,
        CovalentModule,
        BackendModule.forRoot({environmentType: 0, restServiceRoot: 'v1'}),
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    dialog = TestBed.get(MdDialog);
    component = dialog.open(OrderDialogComponent, { data : {dialogData: { row: undefined }}}).componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
