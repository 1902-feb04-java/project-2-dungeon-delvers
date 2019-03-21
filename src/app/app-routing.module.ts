import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { CampaignComponent } from './campaign/campaign.component';
import { CharacterComponent } from './character/character.component';
import { CharacterCreationComponent } from './character-creation/character-creation.component';
import { MonsterCreationComponent } from './monster-creation/monster-creation.component';
import { CampaignCreationComponent } from './campaign-creation/campaign-creation.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { ChatWindowComponent } from './chat-window/chat-window.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'register-form', component: RegisterFormComponent},
  {path: 'home', component: HomeComponent},
  {path: 'campaign', component: CampaignComponent},
  {path: 'character', component: CharacterComponent},
  {path: 'pccreation', component: CharacterCreationComponent},
  {path: 'monstercreation', component: MonsterCreationComponent},
  {path: 'campaign/create', component: CampaignCreationComponent},
  {path: 'chat-window', component: ChatWindowComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {  }
