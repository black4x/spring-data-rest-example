package com.example.tenant.model;

import com.example.tenant.model.type.CategoryType;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static javax.persistence.CascadeType.ALL;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Short id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private URL url;

    @ManyToOne
    private Category parent;

    @OneToMany(mappedBy = "parentCategory")
    private List<Section> sections = new ArrayList<>();

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryType type;

    @OneToMany(mappedBy = "parent", cascade = ALL)
    private List<Category> children = new ArrayList<>();

    public Category(@NotNull String name, URL url, @NotNull CategoryType type) {
        this.name = name;
        this.url = url;
        this.type = type;
    }

    public void addChild(Category category) {
        category.setParent(this);
        children.add(category);
    }
}
