import { Component } from '@angular/core';
import { UtilityService } from './service/utility.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularapp';

  constructor(public service: UtilityService){}

  logout():void{
    this.service.logout()
  }
}
