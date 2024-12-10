import { Component, OnInit } from '@angular/core';
import { WebsocketService } from '../../services/websocket.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css'],
})
export class TicketComponent implements OnInit {
  ticketUpdates: string[] = []; // To display ticket updates
  vendorName = '';
  ticketCount = 0;
  customerName = '';

  constructor(private websocketService: WebsocketService) {}

  ngOnInit() {
    // Subscribe to ticket updates
    this.websocketService.subscribeToTickets((message: string) => {
      this.ticketUpdates.push(message);
    });
  }

  // Add tickets
  addTicket() {
    this.websocketService.addTicket(this.vendorName, this.ticketCount);
    this.vendorName = '';
    this.ticketCount = 0;
  }

  // Buy ticket
  buyTicket() {
    this.websocketService.buyTicket(this.customerName);
    this.customerName = '';
  }
}
