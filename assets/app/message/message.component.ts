import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Message} from "./message.model";
import {MessageService} from "./message.service";

@Component({
    selector: 'app-message',
    templateUrl: './message.component.html'
})
export class MessageComponent {
    @Input() message: Message;

    constructor(private messageService:MessageService){}

    onEdit() {
        this.messageService.editMessage(this.message);
    }

    onDelete() {
        this.messageService.deleteMessage(this.message).subscribe(
            result => console.log(result)
        );
    }

    isBelongsToUser() {
        return localStorage.getItem('user_id') == this.message.user_id;
    }
}