package com.example.tenant.model.projection;

import com.example.tenant.model.Category;
import java.net.URL;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "base", types = {Category.class})
public interface BaseCategory {

    Short getId();

    String getName();

    URL getUrl();

}
