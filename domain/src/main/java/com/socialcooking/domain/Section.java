package com.socialcooking.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section extends DomainObject {

    private String name;
    private String description;

    private Set<Recipe> recipes = new HashSet<Recipe>();

    public Section() {

    }

    public Section(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Column(name = "name_section")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;

        Section section = (Section) o;

        if (description != null ? !description.equals(section.description) : section.description != null) return false;
        if (name != null ? !name.equals(section.name) : section.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

}
