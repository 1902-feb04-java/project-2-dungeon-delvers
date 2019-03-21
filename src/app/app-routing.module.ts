import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { CampaignComponent } from './campaign/campaign.component';
import { CharacterComponent } from './character/character.component';
import { CharacterCreationComponent } from './character-creation/character-creation.component';
<<<<<<< HEAD
import { EncounterCreationComponent } from './encounter-creation/encounter-creation.component';
=======
import { MonsterCreationComponent } from './monster-creation/monster-creation.component';
>>>>>>> cba64bb67f725cd6f8e3c2c0d4f4c2f1568a8d4c


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent},
  {path: 'campaign', component: CampaignComponent},
  {path: 'character', component: CharacterComponent},
  {path: 'pccreation', component: CharacterCreationComponent},
<<<<<<< HEAD
  {path: 'enccreation', component: EncounterCreationComponent}
=======
  {path: 'monstercreation', component: MonsterCreationComponent}
>>>>>>> cba64bb67f725cd6f8e3c2c0d4f4c2f1568a8d4c
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {  }
