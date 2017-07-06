import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '@angular/material';
import { CovalentModule } from '../shared/covalent.module';

import { HomeComponent } from './home.component';


// REVIEW redundant import declarations like below can be found in several modules. We should check all modules importing the shared module for this.
@NgModule({
  imports: [
    CommonModule, // REVIEW should not be needed since we import shared CovalentModule already
    CovalentModule,
    MaterialModule, // REVIEW should not be needed since we import shared CovalentModule already
  ],
  providers: [
  ],
  declarations: [
    HomeComponent,
  ],
  exports: [
    HomeComponent,
  ],
})
export class HomeModule { }
