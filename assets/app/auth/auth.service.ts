import {User} from "./user.model";
import {Headers, Http, Response} from "@angular/http";
import {EventEmitter, Injectable} from "@angular/core";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";

@Injectable()
export class AuthService {

    constructor(private http: Http) {
    }

    signUp(user: User) {

        let header = new Headers({'content-type': 'application/json'});
        return this.http.post('http://localhost:3000/auth', JSON.stringify(user), {headers: header})
            .map((response: Response) => response.json())
            .catch((error: Response) => Observable.throw(error.json()));
    }

    signIn(user: User) {

        let header = new Headers({'content-type': 'application/json'});
        return this.http.post('http://localhost:3000/auth/signin', JSON.stringify(user), {headers: header})
            .map((response: Response) => response.json())
            .catch((error: Response) => Observable.throw(error.json()));
    }

    logout() {
        localStorage.clear();
    }

    isLoggedIn()
    {
        return localStorage.getItem('token') !== null;
    }
}