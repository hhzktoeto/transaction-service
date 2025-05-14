package hhz.ktoeto.transactionservice.service;

import hhz.ktoeto.transactionservice.exception.EntityNotFoundException;
import hhz.ktoeto.transactionservice.mapper.TransactionMapper;
import hhz.ktoeto.transactionservice.model.dto.TransactionDTO;
import hhz.ktoeto.transactionservice.model.entity.Category;
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
    private final CategoryService categoryService;
    private final TransactionsRepository repository;

    @Transactional
    public List<TransactionDTO> getAll() {
        log.debug("Fetching all transactions ");
        return repository.findAll()
                .stream()
                .map(mapper::toDto).toList();
    }

    @Transactional
    public TransactionDTO getById(long id) {
        Transaction transaction = getTransactionFromRepository(id);
        return mapper.toDto(transaction);
    }

    @Transactional
    public TransactionDTO create(TransactionDTO dto) {
        Category category = categoryService.findByName(dto.category());
        Transaction transaction = mapper.toEntity(dto);
        transaction.setCategory(category);

        Transaction saved = repository.save(transaction);

        return mapper.toDto(saved);
    }

    @Transactional
    public TransactionDTO update(TransactionDTO dto) {
        Transaction transaction = getTransactionFromRepository(dto.id());

        mapper.updateEntity(transaction, dto);
        if (!transaction.getCategory().getName().equals(dto.category())) {
            Category category = categoryService.findByName(dto.category());
            transaction.setCategory(category);
        }

        return mapper.toDto(repository.save(transaction));
    }

    @Transactional
    public void delete(long id) {
        Transaction transaction = getTransactionFromRepository(id);
        repository.delete(transaction);
    }

    private Transaction getTransactionFromRepository(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find Transaction with id %s".formatted(id)));
    }
}
