package com.example.tenant.repository;

import com.example.tenant.model.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "sections")
public interface SectionRepository extends CrudRepository<Section, Short> {
}
