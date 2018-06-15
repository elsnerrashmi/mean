import {RouterModule, Routes} from "@angular/router";
import {SigninComponent} from "./signin.component";
import {SignupComponent} from "./signup.component";
import {LogoutComponent} from "./logout.component";

const AUTH_ROUTES:Routes = [
    {path:'',redirectTo:'signup',pathMatch:'full'},
    {path:'signin',component:SigninComponent},
    {path:'signup',component:SignupComponent},
    {path:'logout',component:LogoutComponent},
];

export const AuthRoutes = RouterModule.forChild(AUTH_ROUTES);


