import { Component } from '@angular/core';


interface SideNavToogle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'analyzCorp';

  isSideNavCollapsed: boolean = false;
  screenWidth: number = 0;

  onToggleSideNav(data: SideNavToogle): void{
      this.screenWidth = data.screenWidth;
      this.isSideNavCollapsed = data.collapsed;
  }
}
