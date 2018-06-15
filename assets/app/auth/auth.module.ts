import {NgModule} from "@angular/core";
import {SigninComponent} from "./signin.component";
import {SignupComponent} from "./signup.component";
import {LogoutComponent} from "./logout.component";
import {ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {AuthRoutes} from "./auth.routing";

@NgModule({
    declarations:[
        SigninComponent,
        SignupComponent,
        LogoutComponent
    ],
    imports : [
        ReactiveFormsModule,
        CommonModule,
        AuthRoutes
    ]

})
export class AuthModule {

}