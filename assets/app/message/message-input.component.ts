import {Component, OnInit} from '@angular/core';
import {MessageService} from "./message.service";
import {Message} from "./message.model";
import {NgForm} from "@angular/forms";

@Component({
    selector: 'messages-input',
    templateUrl: './message-input.component.html',

})
export class MessageInputComponent implements OnInit{
    message:Message;

    constructor(private messgaeService:MessageService){}

    ngOnInit() {
          this.messgaeService.messageIsEdit.subscribe(
              (message:Message) => this.message = message
          );
    }

    onClear(form:NgForm) {
        this.message = null;
        form.resetForm();
    }


    onSubmit(form:NgForm) {
        if(this.message)
        {
            this.message.content = form.value.content;
            this.messgaeService.updateMessage(this.message).subscribe(
                data=>console.log(data),
                error=>console.log(error)
            );
            form.resetForm();
            this.message = null;
        }
        else
        {
            const message = new Message(form.value.content,'Rashmi');
            this.messgaeService.addMessage(message).subscribe(
                data=>console.log(data),
                error=>console.log(error)
            );
            form.resetForm();
        }
    }
}