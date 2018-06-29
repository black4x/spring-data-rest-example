/*
 * Copyright (C) Tamedia AG 2018
 */

package com.example.tenant.model;

import com.example.tenant.model.type.SectionType;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Id
    @GeneratedValue
    private Short id;

    @ManyToOne
    private Category parentCategory;

    @OneToOne
    private Category pointerCategory;

    @Column(nullable = false)
    private String title;

    private Integer teaserCount;

    //@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SectionType sectionType;

    //@Column(nullable = false)
    private Integer position;

    public Section(Category parentCategory, Category pointerCategory, String title) {
        this.parentCategory = parentCategory;
        this.pointerCategory = pointerCategory;
        this.title = title;
    }
}
