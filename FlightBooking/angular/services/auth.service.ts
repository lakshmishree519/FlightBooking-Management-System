import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  public baseUrl:string="https://8080-aabcbaefeccfa320543897abfabbbafcaffedecbcfone.premiumproject.examly.io/api"
  //baseUrl:string="http://aabcbaefeccfa320543897abfabbbafcaffedecbcfone.premiumproject.examly.io:8080/api"
  getUsers():Observable<User[]>{
    return this.http.get<User[]>(this.baseUrl)
  }
  getUserById(userId:number):Observable<User>{
    return this.http.get<User>(this.baseUrl+"/"+userId)
  }
  deleteUser(UserId:number):Observable<void>{
    return this.http.delete<void>(this.baseUrl+"/"+UserId)
  }
  addUser(User:User):Observable<User>{
    return this.http.post<User>(this.baseUrl+"/register",User)
  }
  loginUser(user:any):Observable<User>{
    console.log(user);
    return this.http.post<User>(this.baseUrl+"/login",user)
  }
  updateUser(User:User):Observable<User>{
    return this.http.put<User>(this.baseUrl+"/"+User.userId,User)
  }
  constructor(private http:HttpClient) { }
}
