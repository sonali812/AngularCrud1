import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-alluser',
  templateUrl: './alluser.component.html',
  styleUrls: ['./alluser.component.css']
})
export class AlluserComponent implements OnInit {

  users:User[];
  
  constructor(private service:UserserviceService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(){
    this.service.getUserList().subscribe(data=>{
      this.users=data;
    });
  }
  viewUser(id:number){
    this.router.navigate([`/view`,+id]);
 }
 updateUser(id:number){
    this.router.navigate([`/update`,+id]);
 }

 deleteUser(id:number){
  this.service.deleteUser(id).subscribe(data=>{
    alert("Data Deleted Successfully");
    console.log(data);
    
    this.getUser(); 
  })
}
 
  

}
