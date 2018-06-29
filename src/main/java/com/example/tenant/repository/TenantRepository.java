package com.example.tenant.repository;

import com.example.tenant.model.Tenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tenants")
public interface TenantRepository extends CrudRepository<Tenant, Short> {
}
