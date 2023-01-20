import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  id:number;
  user : User;
 

  constructor(private service:UserserviceService, private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.user=new User();
    this.service.getUserById(this.id).subscribe(data=>{
    this.user=data;
    })
    
   }
   
    onSubmit(){
      this.service.updateUser(this.id,this.user).subscribe(data =>{
        alert("Data Updated Succesfully");
               this.goToUserList();

      },error=>console.log(error)); 
      
  }
  goToUserList()
    {
      this.router.navigate([`Users`]);
    }


}
