package com.example.tenant.repository.handler;

import com.example.tenant.exception.DeletePermanentCategoryException;
import com.example.tenant.model.Category;
import com.example.tenant.model.type.CategoryType;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Category.class)
public class CategoryEventHandler {

    @HandleBeforeDelete
    public void handleDelete(Category category) {
        if (category.getType() == CategoryType.PERMANENT) {
            throw new DeletePermanentCategoryException();
        }
    }

}
