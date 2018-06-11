import {RouterModule, Routes} from "@angular/router";
import {MessagesComponent} from "./message/messages.component";
import {AuthenticationComponent} from "./auth/authentication.component";
import {AUTH_ROUTES} from "./auth/auth.routing";

const APP_ROUTES:Routes = [
        {path:'',redirectTo:'/messages',pathMatch:'full'},
        {path:'messages',component:MessagesComponent},
        {path:'auth',component:AuthenticationComponent,children:AUTH_ROUTES},
    ];

export const AppRoutes = RouterModule.forRoot(APP_ROUTES);
