package hhz.ktoeto.transactionservice.mapper;

import hhz.ktoeto.transactionservice.model.dto.TransactionDTO;
import hhz.ktoeto.transactionservice.model.entity.Category;
import hhz.ktoeto.transactionservice.model.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    @Mapping(target = "category", source = "category", qualifiedByName = "mapCategory")
    @Mapping(target = "type", source = "type", qualifiedByName = "mapType")
    TransactionDTO toDto(Transaction transaction);

    @Named("mapCategory")
    default String mapCategory(Category category) {
        return category.getName();
    }

    @Named("mapType")
    default String mapType(Transaction.Type type) {
        return type.name();
    }
}
