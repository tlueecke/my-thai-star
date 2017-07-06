import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CovalentChipsModule,
         CovalentLayoutModule,
         CovalentExpansionPanelModule,
         CovalentDataTableModule,
         CovalentPagingModule,
         CovalentDialogsModule,
         CovalentLoadingModule,
         CovalentNotificationsModule,
         CovalentCommonModule } from '@covalent/core';
import { MaterialModule } from '@angular/material';

@NgModule({
  exports: [
    CommonModule,
    CovalentChipsModule,
    CovalentLayoutModule,
    CovalentLoadingModule,
    CovalentExpansionPanelModule,
    CovalentDataTableModule,
    CovalentPagingModule,
    CovalentNotificationsModule,
    CovalentCommonModule,
    CovalentDialogsModule,
    MaterialModule,
  ],
  declarations: [],
  providers: [],
})
// REVIEW my guess is that this is used as a shared module as defined by Angular best practices.
// Should we not rename it as such then (e.g. at least SharedCovalentModule)
// https://angular.io/guide/ngmodule#shared-modules
export class CovalentModule { }
