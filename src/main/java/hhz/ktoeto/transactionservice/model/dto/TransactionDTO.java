package hhz.ktoeto.transactionservice.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDTO(
        String type,
        String category,
        LocalDate date,
        BigDecimal amount,
        String description
) {
}
