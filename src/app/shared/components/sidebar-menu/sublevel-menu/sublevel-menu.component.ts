import {Component, Input, OnInit} from '@angular/core';
import {fadeInOut, INavbarData} from "../helpers";
import {animate, state, style, transition, trigger} from "@angular/animations";
import {Router} from "@angular/router";

@Component({
  selector: 'shared-sublevel-menu',
  templateUrl: './sublevel-menu.component.html',
  styleUrl: './../sidebar-menu.component.css',
  animations: [
    fadeInOut,
    trigger('submenu', [
      state('hidden', style({
        height: '0',
        overflow: 'hidden'
      })),
      state('visible', style({
        height: '*',
      })),
      transition('visible <=> hidden', [
        style({overflow: 'hidden'}),
        animate('{{transitionParams}}'),
      ]),
      transition('void => *', animate(0))
    ])
  ]
})
export class SublevelMenuComponent implements OnInit{

  @Input() data: INavbarData = {
    routeLink: '',
    icon: '',
    label: '',
    items:[]
  }

  @Input() collapsed: boolean = false;
  @Input() animating: boolean | undefined;
  @Input() expanded: boolean | undefined;
  @Input() multiple: boolean = false;

  constructor(public router: Router) {}

  ngOnInit() {
  }

  handleClick(item: any): void{
    if(!this.multiple){
      if(this.data.items && this.data.items.length > 0){
        for(let modelItem of this.data.items){
          if(item !== modelItem && modelItem.expanded){
            modelItem.expanded = false;
          }
        }
      }
    }
    item.expanded = !item.expanded;
  }

  getActiveClass(item: INavbarData): string{
    return item.expanded && this.router.url.includes(item.routeLink) ? 'active-sublevel' : '';
  }
}
