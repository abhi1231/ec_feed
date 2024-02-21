package com.ec.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryItemEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;

    public Long getCategory_id() {
        return id;
    }

    public void setCategory_id(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
