package desafio.backend.itau.springboot.controller;

import desafio.backend.itau.springboot.dto.TransactionDTO;
import desafio.backend.itau.springboot.model.Transaction;
import desafio.backend.itau.springboot.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionDTO request) {
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0) {
            return ResponseEntity.unprocessableContent().build();
        }

        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }

}
