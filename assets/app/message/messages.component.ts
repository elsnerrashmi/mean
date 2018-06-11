import { Component } from '@angular/core';
import {MessageService} from "./message.service";
import {Message} from "./message.model";
import {NgForm} from "@angular/forms";

@Component({
    selector: 'messages',
    template: `
        <messages-input></messages-input>
        <messages-list></messages-list>
    `

})
export class MessagesComponent {

}