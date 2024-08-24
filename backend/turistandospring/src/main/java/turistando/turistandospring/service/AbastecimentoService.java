package turistando.turistandospring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turistando.turistandospring.Exception.Excecao;
import turistando.turistandospring.model.AbastecimentoModel;
import turistando.turistandospring.repository.AbastecimentoRepository;

import java.util.List;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    // Criar um novo abastecimento
    public AbastecimentoModel createAbastecimento(AbastecimentoModel abastecimentoModel) {
        return abastecimentoRepository.save(abastecimentoModel);
    }

    // Obter todos os abastecimentos
    public List<AbastecimentoModel> getAllAbastecimentos() {
        return abastecimentoRepository.findAll();
    }

    // Obter um abastecimento por ID
    public AbastecimentoModel getAbastecimentoById(Long id) throws Excecao {
        return abastecimentoRepository.findById(id)
                .orElseThrow(() -> new Excecao("Abastecimento não encontrado com o ID: " + id));
    }

    // Atualizar um abastecimento existente
    public AbastecimentoModel updateAbastecimento(Long id, AbastecimentoModel updatedAbastecimento) throws Excecao {
        if (abastecimentoRepository.existsById(id)) {
            updatedAbastecimento.setId(id);
            return abastecimentoRepository.save(updatedAbastecimento);
        }
        throw new Excecao("Abastecimento não encontrado com o ID: " + id);
    }

    // Deletar um abastecimento por ID
    public boolean deleteAbastecimento(Long id) {
        if (abastecimentoRepository.existsById(id)) {
            abastecimentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public double calcularConsumoMedioPorLitro(String id) {
        List<AbastecimentoModel> abastecimentos = abastecimentoRepository.findByVeiculoPlacaOrderByQuilometragemAsc(id);
        
        if (abastecimentos.size() < 2) {
            throw new IllegalArgumentException("Não há abastecimentos suficientes para calcular o consumo médio.");
        }
        
        double totalQuilometros = 0;
        double totalLitros = 0;
        
        for (int i = 1; i < abastecimentos.size(); i++) {
            AbastecimentoModel anterior = abastecimentos.get(i - 1);
            AbastecimentoModel atual = abastecimentos.get(i);
            
            int quilometragemAnterior = anterior.getQuilometragem();
            int quilometragemAtual = atual.getQuilometragem();
            double litrosAbastecidos = atual.getQuantidade();
            
            totalQuilometros += quilometragemAtual - quilometragemAnterior;
            totalLitros += litrosAbastecidos;
        }
        
        return totalQuilometros / totalLitros;
    }
}
