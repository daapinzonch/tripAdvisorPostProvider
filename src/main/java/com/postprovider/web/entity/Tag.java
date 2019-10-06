package com.postprovider.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;



public class Tag implements Serializable {

    //private String imageUrl;
    private String description;
    private String name;

    public Tag(String name, String description) {
        this.description = description;
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return description.equals(tag.description) &&
                name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name);
    }
}
