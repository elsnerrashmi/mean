import {Component} from "@angular/core";

@Component({
    selector:'header',
    template:`
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" >Mean App</a>
                </div>
                <ul class="nav navbar-nav">
                    <li routerLinkActive="active"><a [routerLink]="['/messages']">Messages</a></li>
                    <li routerLinkActive="active"><a [routerLink]="['/auth']">Auth</a></li>
                </ul>
            </div>
        </nav>
    `
})
export class HeaderComponent {


}