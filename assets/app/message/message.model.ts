export class Message {
    constructor(
        public content:string,
        public username:string,
        public message_id?:string,
        public user_id?:string,
    ){}

}