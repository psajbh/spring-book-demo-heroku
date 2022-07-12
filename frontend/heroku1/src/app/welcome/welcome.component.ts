import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  title = 'heroku1';
  message = 'Big howdy from John Hart';
  msg = 'XYZ';

  constructor() { }
    ngOnInit(): void {
  }

}
