import { Component, Input } from '@angular/core';

@Component({
  selector: 'shared-body',
  templateUrl: './body.component.html',
  styleUrl: './body.component.css'
})
export class BodyComponent {

  @Input()
  collpsed = false;

  @Input()
  screenWidth = 0;

  getBodyClass(): string{
    let styleClass = '';

    if(this.collpsed && this.screenWidth > 768){
      styleClass = 'body-trimmed';
    }
    else if(this.collpsed && this.screenWidth <= 768 && this.screenWidth > 0){
      styleClass = 'body-md-screen'
    }
    return styleClass;
  }
}
