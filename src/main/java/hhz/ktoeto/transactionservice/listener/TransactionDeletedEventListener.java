package hhz.ktoeto.transactionservice.listener;

import hhz.ktoeto.transactionservice.event.CheckCategoryUsageEvent;
import hhz.ktoeto.transactionservice.model.entity.Category;
import hhz.ktoeto.transactionservice.service.CategoryService;
import hhz.ktoeto.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionDeletedEventListener implements ApplicationListener<CheckCategoryUsageEvent> {

    private final TransactionService transactionService;
    private final CategoryService categoryService;

    @Override
    public void onApplicationEvent(@NonNull CheckCategoryUsageEvent event) {
        log.debug("Transaction was mutated. Handling event: {}", event);
        Category category = event.getCategory();
        boolean categoryNeeded = transactionService.existsByCategoryId(category.getId());
        if (!categoryNeeded) {
            log.info("No transactions left with category: {}. Deleting category", category);
            categoryService.delete(category.getId());
        }
    }
}
