package com.example.tenant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue
    private Short id;

    @Column(nullable = false)
    private String name;

    public Tenant(String name) {
        this.name = name;
    }
}