import {Component, OnInit} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "./auth.service";
import {User} from "./user.model";

@Component({
    selector:'signin',
    templateUrl:'./signup.component.html'
})
export class SignupComponent implements OnInit{
    signupform : FormGroup;

    constructor(private authService:AuthService){}

    ngOnInit() {
        this.signupform = new FormGroup({
            firstname:new FormControl(null,Validators.required),
            lastname:new FormControl(null,Validators.required),
            email:new FormControl(null,Validators.required),
            password:new FormControl(null,Validators.required),
        })
    }

    onSubmit() {
        const user = new User(
            this.signupform.value.email,
            this.signupform.value.password,
            this.signupform.value.firstname,
            this.signupform.value.lastname,
        );
        this.authService.signUp(user).subscribe(
            data => console.log(data)
        );
    }
}