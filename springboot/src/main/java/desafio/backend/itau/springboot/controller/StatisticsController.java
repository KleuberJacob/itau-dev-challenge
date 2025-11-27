package desafio.backend.itau.springboot.controller;

import desafio.backend.itau.springboot.dto.ResponseTransactionDTO;
import desafio.backend.itau.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<ResponseTransactionDTO> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new ResponseTransactionDTO(stats));
    }

}
