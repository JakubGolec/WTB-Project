import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  @ViewChild('messageWrapper', { static: false }) messageWrapper: ElementRef;

  message: string[] = ['Hey', 'Dashboard page', 'is working', 'properly!', ':)'];
  text: string;
  counter = 0;

  constructor() {
  }

  ngOnInit() {
    setInterval(() => {
      this.text = this.message[this.counter];
      this.counter++;
      this.changeColor();

      if (this.counter > this.message.length) {
        this.counter = 0;
      }

    }, 1000);
  }

  static getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }

  changeColor() {
    this.messageWrapper.nativeElement.style.color = DashboardComponent.getRandomColor();
    this.messageWrapper.nativeElement.ownerDocument.body.style.backgroundColor = DashboardComponent.getRandomColor();
  }
}
