package hhz.ktoeto.transactionservice.mapper;

import hhz.ktoeto.transactionservice.model.dto.TransactionDTO;
import hhz.ktoeto.transactionservice.model.entity.Category;
import hhz.ktoeto.transactionservice.model.entity.Transaction;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    @Mapping(target = "category", source = "category", qualifiedByName = "mapCategory")
    @Mapping(target = "type", source = "type", qualifiedByName = "mapType")
    TransactionDTO toDto(Transaction transaction);

    @Mapping(target = "category", ignore = true)
    Transaction toEntity(TransactionDTO transactionDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntity(@MappingTarget Transaction transaction, TransactionDTO transactionDTO);

    @Named("mapCategory")
    default String mapCategory(Category category) {
        return category.getName();
    }

    @Named("mapType")
    default String mapType(Transaction.Type type) {
        return type.name();
    }
}
