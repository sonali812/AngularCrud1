import { Component, OnInit } from '@angular/core';
import { EmailValidator, FormBuilder, FormControl, FormGroup, PatternValidator, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css']
})
export class CreateuserComponent implements OnInit {

  //const ="^[a-zA-Z0-9_-+&*-]+(?:\\."+"[a-zA-Z0-9_-+&*-]+*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
  user : User=new User();
  register: FormGroup;

  constructor(private service:UserserviceService, private router: Router,private formbuiler:FormBuilder) { }
  ngOnInit(): void {
    this.register=this.formbuiler.group({ 
      email: new FormControl('',[  Validators.required,
                                     Validators.minLength(8), 
                                     Validators.maxLength(30),
                                     Validators.pattern('/[a-zA-Z0-9_\-\.]+@[a-z]+[\.][a-z]{2,3}*')]),

      firstName: new FormControl('',[ Validators.required,
                                      Validators.minLength(2),
                                      Validators.pattern('[a-zA-Z]*'),
                                      Validators.maxLength(12)]),
                              
      lastName: new FormControl('',[ Validators.required,
                                     Validators.minLength(2),
                                     Validators.pattern('[a-zA-Z]*'),
                                     Validators.maxLength(12)]),

      age: new FormControl('',[ Validators.required,
                                Validators.pattern('[0-9]*'),
                                Validators.maxLength(3)]),
      
                            
    })
  }
 get firstName(){
    return this.register.get('firstName');
 }
 get lastName(){
  return this.register.get('lastName');
}
get email(){
  return this.register.get('email');
}
get age(){
  return this.register.get('age');
}

  
    
    onSubmit(){
      console.log(this.user); 
      this.saveUser();
    }
    saveUser(){
     this.service.createUser(this.user).subscribe(data=>{
      console.log(data);
      alert("Registration Succesfully");
      this.router.navigate(['Users']);
      },
    error=>console.log(error));  
    }
    
 

}
