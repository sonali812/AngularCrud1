import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

 private baseURL="http://localhost:8080/api/v1/User";
  
  constructor(private http:HttpClient) { }


  getUserList(): Observable<User[]>{
    return this.http.get<User[]>(`${this.baseURL}`);
  }
 createUser(user:User): Observable<object>{
    return this.http.post(`${this.baseURL}`,user);
 }
 getUserById(id:number): Observable<User>{
  return this.http.get<User>(`${this.baseURL}/${id}`);
 }
 updateUser(id:number, user:User): Observable<object>{
  return this.http.put(`${this.baseURL}/${id}`,user);
}
deleteUser(id:number): Observable<object>{
  return this.http.delete(`${this.baseURL}/${id}`);
}

}
