import { Component, EventEmitter, Output } from '@angular/core';
import { navbarData } from './nav-data';

interface SideNavToogle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'shared-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrl: './sidebar-menu.component.css'
})
export class SidebarMenuComponent {


  @Output()
  onToggleSideNav: EventEmitter<SideNavToogle> = new EventEmitter();

  screenWidth = 0;
  collapsed: boolean = true;
  navData = navbarData;

  closeSidenav():void {
    this.collapsed = false;

    this.onToggleSideNav.emit({
      collapsed: this.collapsed,
      screenWidth: this.screenWidth,
    })
  }

  toggleCollapse():void {
    this.collapsed = !this.collapsed;

    this.onToggleSideNav.emit({
      collapsed: this.collapsed,
      screenWidth: this.screenWidth,
    })
  }
}
