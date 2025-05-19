package hhz.ktoeto.transactionservice.event;

import hhz.ktoeto.transactionservice.model.entity.Category;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CheckCategoryUsageEvent extends ApplicationEvent {
    private final Category category;

    public CheckCategoryUsageEvent(Object source, Category category) {
        super(source);
        this.category = category;
    }
}
