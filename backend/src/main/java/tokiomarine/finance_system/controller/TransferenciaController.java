package tokiomarine.finance_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tokiomarine.finance_system.model.Transferencia;
import tokiomarine.finance_system.repository.TransferenciaRepository;
import tokiomarine.finance_system.service.TransferenciaService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping("/agendar")
    public ResponseEntity<?> agendarTransferencia(@Valid @RequestBody Transferencia transferencia) {
        try {
            BigDecimal taxa;
            taxa = transferenciaService.calcularTaxa(transferencia.getDataTransferencia(), transferencia.getValor());
            transferencia.setTaxa(taxa);
            transferencia.setDataAgendamento(LocalDate.now());
            transferenciaRepository.save(transferencia);

            return ResponseEntity.ok("Transferência agendada com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listarTransferencias() {
        List<Transferencia> transferencias = transferenciaRepository.findAll();
        return ResponseEntity.ok(transferencias);
    }
}
