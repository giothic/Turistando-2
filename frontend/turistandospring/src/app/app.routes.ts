import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastroVeiculoComponent } from './cadastro-veiculo/cadastro-veiculo.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cadastrar-veiculo', component: CadastroVeiculoComponent }
];
