package turistando.turistandospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import turistando.turistandospring.model.GastoModel;

import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<GastoModel, Long> {
    List<GastoModel> findByCategoria(String categoria);
}


