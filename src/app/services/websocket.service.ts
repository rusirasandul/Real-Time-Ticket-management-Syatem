import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class WebsocketService {
  private socket: WebSocket | null = null;  // Initialize to null
  private subject = new Subject<string>();

  connect(url: string): void {
    this.socket = new WebSocket(url);

    this.socket.onmessage = (message) => {
      this.subject.next(message.data);
    };

    this.socket.onclose = () => console.log('WebSocket disconnected');
  }

  sendMessage(message: string): void {
    if (this.socket && this.socket.readyState === WebSocket.OPEN) {
      this.socket.send(message);
    }
  }

  onMessage(): Observable<string> {
    return this.subject.asObservable();
  }
}
