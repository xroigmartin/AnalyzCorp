import { NgModule } from '@angular/core';
import { TabViewModule } from 'primeng/tabview';
import { TableModule } from 'primeng/table';

@NgModule({
  exports: [
    TabViewModule,
    TableModule
  ]
})
export class PrimgNgModule { }
