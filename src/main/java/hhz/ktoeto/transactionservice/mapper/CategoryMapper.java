package hhz.ktoeto.transactionservice.mapper;

import hhz.ktoeto.transactionservice.model.dto.CategoryDTO;
import hhz.ktoeto.transactionservice.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryDTO toDto(Category category);
}
