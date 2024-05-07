import {AfterViewInit, Component, EventEmitter, HostListener, OnInit, Output} from '@angular/core';
import { navbarData } from './nav-data';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";
import {fadeInOut, INavbarData} from "./helpers";
import {Router} from "@angular/router";

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'shared-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrl: './sidebar-menu.component.css',
  animations:[
    fadeInOut,
    trigger('rotate',[
      transition(':enter', [
        animate('1000ms',
          keyframes([
            style({transform: 'rotate(0deg)', offset: '0'}),
            style({transform: 'rotate(2turn)', offset: '1'}),
          ])
        )
      ])
    ])
  ]
})
export class SidebarMenuComponent implements OnInit {


  @Output()
  onToggleSideNav: EventEmitter<SideNavToggle> = new EventEmitter();

  screenWidth:number = 0;
  collapsed: boolean = false;
  navData: INavbarData[] = navbarData;
  multiple: boolean = false;


  @HostListener('window:resize', ['$event'])
  onResize(event: any): void {
    this.screenWidth = window.innerWidth;

    if(this.screenWidth <= 768){
      this.collapsed = false;
      this.onToggleSideNav.emit({
        collapsed: this.collapsed,
        screenWidth: this.screenWidth,
      })
    }

    if(this.screenWidth > 768){
      this.collapsed = true;
      this.onToggleSideNav.emit({
        collapsed: this.collapsed,
        screenWidth: this.screenWidth,
      })
    }
  }

  constructor(public router: Router) {}

  ngOnInit(): void {
    this.screenWidth = window.innerWidth;
    if(this.screenWidth > 768){
      this.collapsed = true;
      this.onToggleSideNav.emit({
        collapsed: this.collapsed,
        screenWidth: this.screenWidth,
      })
    }

    if(this.screenWidth <= 768){
      this.collapsed = false;
      this.onToggleSideNav.emit({
        collapsed: this.collapsed,
        screenWidth: this.screenWidth,
      })
    }
  }

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

  handleClick(item: INavbarData): void{
    this.shrinkItems(item);
    item.expanded = !item.expanded
  }

  getActiveClass(data: INavbarData): string{
    return this.router.url.includes(data.routeLink) ? 'active' : '';
  }

  shrinkItems(item: INavbarData): void {
    if (!this.multiple) {
      for(let modelItem of this.navData) {
        if (item !== modelItem && modelItem.expanded) {
          modelItem.expanded = false;
        }
      }
    }
  }
}
