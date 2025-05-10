package hhz.ktoeto.transactionservice.service;

import hhz.ktoeto.transactionservice.mapper.TransactionMapper;
import hhz.ktoeto.transactionservice.model.dto.TransactionDTO;
import hhz.ktoeto.transactionservice.model.entity.Transaction;
import hhz.ktoeto.transactionservice.repository.TransactionsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionMapper mapper;
    private final TransactionsRepository repository;

    @Transactional
    public List<TransactionDTO> getAll() {
        List<Transaction> transactions = repository.findAll();
        return transactions.stream().map(mapper::toDto).toList();
    }
}
