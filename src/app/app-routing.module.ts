import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { CampaignComponent } from './campaign/campaign.component';
import { CharacterComponent } from './character/character.component';
import { CharacterCreationComponent } from './character-creation/character-creation.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent},
  {path: 'campaign', component: CampaignComponent},
  {path: 'character', component: CharacterComponent},
  {path: 'pccreation', component: CharacterCreationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {  }
