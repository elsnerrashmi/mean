import {User} from "./user.model";
import {Headers, Http, Response} from "@angular/http";
import {EventEmitter, Injectable} from "@angular/core";
import 'rxjs/Rx';
import {Observable} from "rxjs/Observable";
import { ErrorService } from "../errors/error.service";

@Injectable()
export class AuthService {

    constructor(private http: Http , private errorService: ErrorService) {
    }

    signUp(user: User) {

        let header = new Headers({'content-type': 'application/json'});
        return this.http.post('http://localhost:8292/auth', JSON.stringify(user), {headers: header})
            .map((response: Response) => response.json())
            .catch((error: Response) => 
            {
                this.errorService.handleError(error.json());
                return Observable.throw(error.json());
            });
    }

    signIn(user: User) {

        let header = new Headers({'content-type': 'application/json'});
        return this.http.post('http://localhost:8292/auth/signin', JSON.stringify(user), {headers: header})
            .map((response: Response) => response.json())
            .catch((error: Response) => 
            {
                this.errorService.handleError(error.json());
                return Observable.throw(error.json());
            });
    }

    logout() {
        localStorage.clear();
    }

    isLoggedIn()
    {
        return localStorage.getItem('token') !== null;
    }
}