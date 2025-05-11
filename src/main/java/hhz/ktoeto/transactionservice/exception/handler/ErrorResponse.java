package hhz.ktoeto.transactionservice.exception.handler;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String message,
        Integer code
) {

}
