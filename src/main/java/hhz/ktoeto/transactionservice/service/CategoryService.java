package hhz.ktoeto.transactionservice.service;

import hhz.ktoeto.transactionservice.mapper.CategoryMapper;
import hhz.ktoeto.transactionservice.model.dto.CategoryDTO;
import hhz.ktoeto.transactionservice.model.entity.Category;
import hhz.ktoeto.transactionservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper mapper;
    private final CategoryRepository repository;

    public Category findByName(String name) {
        log.debug("Trying to find category by name {}", name);
        return repository.findByName(name).orElseGet(() -> {
            Category category = new Category();
            category.setName(name);
            return repository.save(category);
        });
    }

    public CategoryDTO create(CategoryDTO dto) {
        log.debug("Creating new category: {}", dto.name());
        Category category = mapper.toEntity(dto);
        return mapper.toDto(repository.save(category));
    }

    public void delete(long id) {
        log.debug("Deleting category with id {}", id);
        repository.deleteById(id);
    }
    
    public List<CategoryDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
