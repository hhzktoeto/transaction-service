package hhz.ktoeto.transactionservice.repository;

import hhz.ktoeto.transactionservice.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
}
