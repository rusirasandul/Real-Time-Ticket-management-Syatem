import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';  // The root component of your application
import { TicketComponent } from './components/ticket/ticket.component';  // Import your component(s)
import { WebsocketService } from './services/websocket.service';  // Import the WebSocket service

@NgModule({
  declarations: [
    AppComponent,         // Declare AppComponent
    TicketComponent,      // Declare any other components like TicketComponent
    // Add more components here as needed
  ],
  imports: [
    BrowserModule,        // Import required Angular modules
    // Add more modules as needed
  ],
  providers: [WebsocketService],  // Provide WebSocketService here
  bootstrap: [AppComponent]       // Bootstrapping the root component
})
export class AppModule { }
