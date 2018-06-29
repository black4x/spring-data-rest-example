package com.example.tenant.model.projection;

import com.example.tenant.model.Category;
import com.example.tenant.model.Section;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "sections", types = {Category.class})
public interface CategorySections {

    @JsonProperty("content")
    List<Section> getSections();

}
