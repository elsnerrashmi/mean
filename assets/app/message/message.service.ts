import {Message} from "./message.model";
import {Headers, Http, Response} from "@angular/http";
import {EventEmitter, Injectable} from "@angular/core";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import { ErrorService } from "../errors/error.service";

@Injectable()
export class MessageService {

    private messages: Message[] = [];
    messageIsEdit = new EventEmitter<Message>();
    constructor(private http: Http, private errorService:ErrorService) {
    }

    addMessage(message: Message) {

        let header = new Headers({'content-type': 'application/json'});
        let token = localStorage.getItem('token') ? '?token='+localStorage.getItem('token') : '';
        return this.http.post('http://localhost:8292/message' + token, JSON.stringify(message), {headers: header})
            .map((response: Response) => {
                const result = response.json()
                const message =  new Message(result.result.content,result.result.user.first_name,result.result._id,result.result.user._id);
                this.messages.push(message);
                return message;
            })
            .catch((error: Response) => 
            {
                this.errorService.handleError(error.json());
                return Observable.throw(error.json());
            });
    }

    getMessages() {
        let token = localStorage.getItem('token') ? '?token='+localStorage.getItem('token') : '';
        return this.http.get('http://localhost:8292/message/'+token)
            .map((response: Response) => {
                    const messages = response.json().result;
                    console.log(messages);
                    let tempMessages: Message[] = [];
                    for (let message of messages) {
                        tempMessages.push(new Message(message.content, message.user.first_name, message._id, message.user._id));
                    }
                    this.messages = tempMessages;
                    return this.messages;
                }
            )
            .catch((error: Response) => 
            {
                this.errorService.handleError(error.json());
                return Observable.throw(error.json());
            });
    }

    editMessage(message:Message){
        this.messageIsEdit.emit(message);
    }

    updateMessage(message:Message) {
        let header = new Headers({'content-type': 'application/json'});
        let token = localStorage.getItem('token') ? '?token='+localStorage.getItem('token') : '';
        return this.http.patch('http://localhost:8292/message/'+message.message_id + token, JSON.stringify(message), {headers: header})
            .map((response: Response) => response.json())
            .catch((error: Response) => 
            {
                this.errorService.handleError(error.json());
                return Observable.throw(error.json());
            });
    }

    deleteMessage(message: Message) {
        this.messages.splice(this.messages.indexOf(message), 1);
        let token = localStorage.getItem('token') ? '?token='+localStorage.getItem('token') : '';
        return this.http.delete('http://localhost:8292/message/'+message.message_id+token)
            .map((response: Response) => response.json())
            .catch((error: Response) => 
            {
                this.errorService.handleError(error.json());
                return Observable.throw(error.json());
            });

    }

}