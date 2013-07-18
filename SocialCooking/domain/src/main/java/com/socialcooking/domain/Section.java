package com.socialcooking.domain;


import javax.persistence.*;

@Entity
@Table(name = "section")
@NamedQueries({
@NamedQuery(name = "Section.findAll", query = "select s from Section s")})
public class Section {

    private String name;
    private String description;

    @Id
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

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
