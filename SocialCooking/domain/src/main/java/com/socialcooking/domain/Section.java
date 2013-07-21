package com.socialcooking.domain;


import javax.persistence.*;

@Entity
@Table(name = "section")
@NamedQueries({
        @NamedQuery(name = "Section.findAll", query = "select s from Section s"),
        @NamedQuery(name = "Section.findById", query = "select s from Section s where s.name = :name")})
public class Section {

    @Id
    @Column(name = "name_section")
    private String name;

    @Column(name = "description")
    private String description;

    public Section() {

    }

    public Section(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
