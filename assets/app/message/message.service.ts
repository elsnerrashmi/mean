import {Message} from "./message.model";
import {Headers, Http, Response} from "@angular/http";
import {EventEmitter, Injectable} from "@angular/core";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";

@Injectable()
export class MessageService {

    private messages: Message[] = [];
    messageIsEdit = new EventEmitter<Message>();
    constructor(private http: Http) {
    }

    addMessage(message: Message) {

        let header = new Headers({'content-type': 'application/json'});
        return this.http.post('http://localhost:3000/message', JSON.stringify(message), {headers: header})
            .map((response: Response) => {
                const result = response.json()
                const message =  new Message(result.result.content,'Rashmi',result.result._id);
                this.messages.push(message);
                return message;
            })
            .catch((error: Response) => Observable.throw(error.json()));
    }

    getMessages() {
        return this.http.get('http://localhost:3000/message/')
            .map((response: Response) => {
                    const messages = response.json().result;
                    console.log(messages);
                    let tempMessages: Message[] = [];
                    for (let message of messages) {
                        tempMessages.push(new Message(message.content, 'Rashmi', message._id, null));
                    }
                    this.messages = tempMessages;
                    return this.messages;
                }
            )
            .catch((error: Response) => Observable.throw(error.json()));
    }

    editMessage(message:Message){
        this.messageIsEdit.emit(message);
    }

    updateMessage(message:Message) {
        let header = new Headers({'content-type': 'application/json'});
        return this.http.patch('http://localhost:3000/message/'+message.message_id, JSON.stringify(message), {headers: header})
            .map((response: Response) => response.json())
            .catch((error: Response) => Observable.throw(error.json()));
    }

    deleteMessage(message: Message) {
        this.messages.splice(this.messages.indexOf(message), 1);
        return this.http.delete('http://localhost:3000/message/'+message.message_id)
            .map((response: Response) => response.json())
            .catch((error: Response) => Observable.throw(error.json()));

    }

}