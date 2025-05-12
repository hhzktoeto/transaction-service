package hhz.ktoeto.transactionservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDTO(
        long id,
        @JsonProperty("user_id")
        long userId,
        String type,
        String category,
        LocalDate date,
        BigDecimal amount,
        String description
) {
}
