import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CadastroVeiculoComponent } from './cadastro-veiculo/cadastro-veiculo.component';
import { RegistrarAbastecimentoComponent } from './registrar-abastecimento/registrar-abastecimento.component';
import { RegistrarDespesaComponent } from './registrar-despesa/registrar-despesa.component';
import { CalcularConsumoMedioComponent } from './calcular-consumo-medio/calcular-consumo-medio.component';
import { ListarVeiculosComponent } from './listar-veiculos/listar-veiculos.component';
import { RelatorioComponent } from './relatorio/relatorio.component';
// import { routes } from './app.routes';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cadastrar-veiculo', component: CadastroVeiculoComponent },
  { path: 'registrar-abastecimento', component: RegistrarAbastecimentoComponent },
  { path: 'registrar-despesa', component: RegistrarDespesaComponent },
  { path: 'calcular-consumo-medio', component: CalcularConsumoMedioComponent },
  { path: 'listar-veiculos', component: ListarVeiculosComponent },
  { path: 'relatorio', component: RelatorioComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
