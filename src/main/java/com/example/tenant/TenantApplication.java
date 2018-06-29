package com.example.tenant;

import com.example.tenant.model.Category;
import com.example.tenant.model.Section;
import com.example.tenant.model.Tenant;
import com.example.tenant.repository.CategoryRepository;
import com.example.tenant.repository.SectionRepository;
import com.example.tenant.repository.TenantRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;

import static com.example.tenant.model.type.CategoryType.PERMANENT;
import static com.example.tenant.model.type.CategoryType.TEMPORARY;

@Log4j2
@SpringBootApplication
@EnableAspectJAutoProxy
public class TenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenantApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CategoryRepository categoryRepository, TenantRepository tenantRepository, SectionRepository sectionRepository) {
        return (String... d) -> {
            Category parent = new Category("parent 1", new URL("http:/parent1"), PERMANENT);

            Category child1 = new Category("child 1", new URL("http:/child1"), TEMPORARY);

            Category child2 = new Category("child 2", new URL("http:/child2"), TEMPORARY);

            parent.addChild(child1);
            parent.addChild(child2);

            child2.addChild(new Category("child child", new URL("http:/child/child"), TEMPORARY));

            categoryRepository.save(parent);

            tenantRepository.save(new Tenant("Berner Zeiting"));

            sectionRepository.save(new Section(parent, child1, "first section"));
            sectionRepository.save(new Section(parent, child2, "second section"));
        };
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                config.exposeIdsFor(Category.class);
                config.exposeIdsFor(Tenant.class);
                config.exposeIdsFor(Section.class);
                config.setDefaultMediaType(MediaType.APPLICATION_JSON);
                config.setReturnBodyForPutAndPost(true);
            }

            @Override
            public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
                objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            }
        };
    }
}
