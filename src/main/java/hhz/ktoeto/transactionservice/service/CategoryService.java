package hhz.ktoeto.transactionservice.service;

import hhz.ktoeto.transactionservice.model.entity.Category;
import hhz.ktoeto.transactionservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    @Cacheable(value = "categories", key = "#name")
    public Category findByName(String name) {
        log.debug("Trying to find category by name {}", name);
        return repository.findByName(name).orElseGet(() -> {
            log.debug("Category not found in DB. Creating new category");
            Category category = new Category();
            category.setName(name);
            return repository.save(category);
        });
    }
}
