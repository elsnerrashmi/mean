import {Component} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {User} from "./user.model";
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";

@Component({
    selector:'signin',
    templateUrl:'./signin.component.html'
})
export class SigninComponent {
    signupform : FormGroup;
    constructor(private authService : AuthService,private router:Router){}
    ngOnInit() {
        this.signupform = new FormGroup({
            email:new FormControl(null,Validators.required),
            password:new FormControl(null,Validators.required),
        })
    }

    onSubmit() {
        const user = new User(
            this.signupform.value.email,
            this.signupform.value.password,
        );
        this.authService.signIn(user).subscribe(
            data => {
                localStorage.setItem('token',data.token);
                localStorage.setItem('user_id',data.user_id);
                this.router.navigateByUrl('/');
            }
        );
    }

}