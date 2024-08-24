import { Component } from '@angular/core';
import { VeiculoService, Veiculo } from '../veiculo.service';

@Component({
  selector: 'app-cadastro-veiculo',
  templateUrl: './cadastro-veiculo.component.html',
  styleUrls: ['./cadastro-veiculo.component.css']
})
export class CadastroVeiculoComponent {
  veiculo: Veiculo = {
    placa: '',
    marca: '',
    modelo: '',
    anoModelo: 0,
    anoFabricacao: 0,
    cor: '',
    renavam: 0,
    motorizacao: 0,
    capacidadeTanque: 0
  };

  constructor(private veiculoService: VeiculoService) { }

  onSubmit(): void {
    this.veiculoService.cadastrarVeiculo(this.veiculo).subscribe({
      next: (result) => {
        console.log('Veículo cadastrado com sucesso!', result);
        // Adicione uma mensagem de sucesso ou redirecione o usuário
      },
      error: (err) => {
        console.error('Erro ao cadastrar veículo:', err);
        // Adicione uma mensagem de erro ou tratamento
      }
    });
  }
}
