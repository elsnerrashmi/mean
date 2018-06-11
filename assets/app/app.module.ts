import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from "./app.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MessageComponent} from "./message/message.component";
import {MessageListComponent} from "./message/message-list.component";
import {MessageInputComponent} from "./message/message-input.component";
import {AuthenticationComponent} from "./auth/authentication.component";
import {HeaderComponent} from "./header.component";
import {AppRoutes} from "./app.routing";
import {MessagesComponent} from "./message/messages.component";
import {SigninComponent} from "./auth/signin.component";
import {SignupComponent} from "./auth/signup.component";
import {LogoutComponent} from "./auth/logout.component";
import {HttpModule} from "@angular/http";
import {AuthService} from "./auth/auth.service";

@NgModule({
    declarations: [
        AppComponent,
        MessageComponent,
        MessageListComponent,
        MessageInputComponent,
        AuthenticationComponent,
        HeaderComponent,
        MessagesComponent,
        SigninComponent,
        SignupComponent,
        LogoutComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        AppRoutes,
        ReactiveFormsModule,
        HttpModule
    ],
    providers:[
        AuthService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {

}