import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimgNgModule } from '../primg-ng/primg-ng.module';
import { SidebarMenuComponent } from './components/sidebar-menu/sidebar-menu.component';
import { RouterModule, RouterOutlet } from '@angular/router';
import { BodyComponent } from './components/body/body.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';



@NgModule({
  declarations: [
    SidebarMenuComponent,
    BodyComponent,
    DashboardComponent
  ],
  imports: [
    CommonModule,
    PrimgNgModule,
    RouterModule,
    RouterOutlet,
  ],
  exports: [
    SidebarMenuComponent,
    BodyComponent,
    DashboardComponent
  ]
})
export class SharedModule { }
