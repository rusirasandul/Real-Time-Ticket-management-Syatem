import { Component } from '@angular/core';
import { WebsocketService } from '../../services/websocket.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
})
export class CustomerComponent {
  constructor(private websocketService: WebsocketService) {}

  buyTicket(): void {
    const message = JSON.stringify({ action: 'buyTicket' });
    this.websocketService.sendMessage(message);
  }
}
