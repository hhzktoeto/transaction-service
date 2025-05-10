package hhz.ktoeto.transactionservice.controller;

import hhz.ktoeto.transactionservice.model.dto.TransactionDTO;
import hhz.ktoeto.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    @GetMapping
    public List<TransactionDTO> getAll() {
        return service.getAll();
    }
}
