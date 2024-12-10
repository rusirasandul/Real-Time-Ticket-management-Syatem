import { Component } from '@angular/core';
import { WebsocketService } from '../../services/websocket.service';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css'],
})
export class VendorComponent {
  constructor(private websocketService: WebsocketService) {}

  addTickets(ticketCount: number): void {
    const message = JSON.stringify({ action: 'addTickets', count: ticketCount });
    this.websocketService.sendMessage(message);
  }
}
