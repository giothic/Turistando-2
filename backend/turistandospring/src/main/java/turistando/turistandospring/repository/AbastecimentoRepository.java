package turistando.turistandospring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import turistando.turistandospring.model.AbastecimentoModel;


public interface AbastecimentoRepository extends JpaRepository<AbastecimentoModel, Long> {

    List<AbastecimentoModel> findByVeiculoPlacaOrderByQuilometragemAsc(String veiculoId);
}

