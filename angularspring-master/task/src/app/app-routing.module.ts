import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlluserComponent } from './alluser/alluser.component';
import { CreateuserComponent } from './createuser/createuser.component';
import { ShowComponent } from './show/show.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [

  {path:'', redirectTo :'Users', pathMatch : 'full'},
  {path:'Users', component: AlluserComponent},
  {path:'register', component: CreateuserComponent},
  {path:'update/:id', component: UpdateComponent},
  {path:'view/:id', component: ShowComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
        

