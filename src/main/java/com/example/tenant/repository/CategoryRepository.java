package com.example.tenant.repository;

import com.example.tenant.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "categories")
public interface CategoryRepository extends CrudRepository<Category, Short> {

    @RestResource(path = "root")
    @Query("select c from Category c where c.parent is null")
    List<Category> showRoot();

}
