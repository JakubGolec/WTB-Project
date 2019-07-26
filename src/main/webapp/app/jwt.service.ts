import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})


export class JwtService {
  constructor(private httpClient: HttpClient) {
  }

  login(nick: string, password: string) {
    return this.httpClient.post<{ access_token: string }>('http://localhost:4200/login', {
      nick,
      password
    }).pipe(tap(res => {
      localStorage.setItem('access_token', res.access_token);
    }))
  }

  register(email: string, password: string) {
    return this.httpClient.post<{ access_token: string }>('http://localhost:4200/register', {
      email,
      password
    }).pipe(tap(res => {
      this.login(email, password)
    }))
  }
  logout() {
    localStorage.removeItem('access_token');
  }
  public get loggedIn(): boolean{
    return localStorage.getItem('access_token') !==  null;
  }
}
