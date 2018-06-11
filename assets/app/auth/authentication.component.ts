import {Component} from "@angular/core";
import {AuthService} from "./auth.service";

@Component({
    selector:'auth',
    template:`
        <nav class="navbar navbar-default">
            <div class="container-fluid">
               
                <ul class="nav navbar-nav">
                    <li routerLinkActive="active" *ngIf="!isLoggedIn()"><a [routerLink]='["signin"]'>SignIn</a></li>
                    <li routerLinkActive="active"><a [routerLink]="['signup']">SignUp</a></li>
                    <li routerLinkActive="active" *ngIf="isLoggedIn()"><a [routerLink]="['logout']">Logout</a></li>
                </ul>
            </div>
        </nav>
        <router-outlet></router-outlet>
    `
})
export class AuthenticationComponent {
    constructor(private authService:AuthService){}

    isLoggedIn()
    {
        return this.authService.isLoggedIn();
    }
}