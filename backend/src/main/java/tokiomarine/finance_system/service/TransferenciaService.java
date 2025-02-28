package tokiomarine.finance_system.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TransferenciaService {
    public BigDecimal calcularTaxa(LocalDate dataTransferencia, BigDecimal valor) {
        long diasDeDiferenca = ChronoUnit.DAYS.between(LocalDate.now(), dataTransferencia);

        if (diasDeDiferenca <= 0) {
            return valor.multiply(new BigDecimal("0.03"));
        } else if (diasDeDiferenca <= 10) {
            return valor.multiply(new BigDecimal("0.025"));
        } else if (diasDeDiferenca <= 20) {
            return valor.multiply(new BigDecimal("0.082"));
        } else if (diasDeDiferenca <= 30) {
            return valor.multiply(new BigDecimal("0.069"));
        } else if (diasDeDiferenca <= 40) {
            return valor.multiply(new BigDecimal("0.047"));
        } else if (diasDeDiferenca <= 50) {
            return valor.multiply(new BigDecimal("0.017"));
        } else {
            throw new IllegalArgumentException("Data de transferência inválida ou não aplicável.");
        }
    }
}
