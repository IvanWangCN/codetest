import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {PetComponent} from "./pet/pet.component";
import {WeatherComponent} from "./weather/weather.component";
import {PagenotfoundComponent} from "./pagenotfound/pagenotfound.component";


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: PetComponent },
  { path: 'weather', component: WeatherComponent },
  { path: '**', component: PagenotfoundComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
