import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  id:number;
  user:User;
  constructor(private service:UserserviceService,private route:ActivatedRoute) { }

  ngOnInit(): void {
  this.id=this.route.snapshot.params['id'];
    this.user=new User();
    this.service.getUserById(this.id).subscribe(data=>{
    this.user=data;
  });
    
  }

}
