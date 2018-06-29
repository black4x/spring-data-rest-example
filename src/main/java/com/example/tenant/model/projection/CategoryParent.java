package com.example.tenant.model.projection;

import com.example.tenant.model.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "parent", types = {Category.class})
public interface CategoryParent extends BaseCategory {

    Category getParent();

}
