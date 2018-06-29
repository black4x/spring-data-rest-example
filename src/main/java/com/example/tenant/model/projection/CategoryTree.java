package com.example.tenant.model.projection;

import com.example.tenant.model.Category;
import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "tree", types = {Category.class})
public interface CategoryTree extends BaseCategory {

    List<CategoryTree> getChildren();

}
