import { Component } from '@angular/core';
import { trigger, transition, animate, style } from '@angular/animations'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  animations: [
    trigger('slideInOut', [
      transition(':enter', [
        style({transform: 'translateY(-100%)'}),
        animate('200ms ease-in', style({transform: 'translateY(0%)'}))
      ]),
      transition(':leave', [
        animate('200ms ease-in', style({transform: 'translateY(-100%)'}))
      ])
    ])
  ]
})
export class HomeComponent {
  slides: String[] = ["Merhaba", "Hello", "Hola", "Bonjour", "Ciao", "Hallo", "Hej", "Ahoj", "Halo", "Salut", "Ola", "Hei", "Szia"];
  visible: boolean = true;
}
