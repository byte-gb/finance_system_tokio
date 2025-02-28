package tokiomarine.finance_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tokiomarine.finance_system.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
