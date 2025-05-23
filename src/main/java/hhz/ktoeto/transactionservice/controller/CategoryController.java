package hhz.ktoeto.transactionservice.controller;

import hhz.ktoeto.transactionservice.model.dto.CategoryDTO;
import hhz.ktoeto.transactionservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public List<CategoryDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public CategoryDTO create(CategoryDTO dto) {
        return service.create(dto);
    }
}
