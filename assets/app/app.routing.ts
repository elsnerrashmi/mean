import {RouterModule, Routes} from "@angular/router";
import {MessagesComponent} from "./message/messages.component";
import {AuthenticationComponent} from "./auth/authentication.component";

const APP_ROUTES:Routes = [
        {path:'',redirectTo:'/messages',pathMatch:'full'},
        {path:'messages',component:MessagesComponent},
        {path:'auth',component:AuthenticationComponent,loadChildren:'./auth/auth.module#AuthModule'},
    ];

export const AppRoutes = RouterModule.forRoot(APP_ROUTES);