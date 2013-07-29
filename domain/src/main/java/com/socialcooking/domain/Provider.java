package com.socialcooking.domain;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "provider")
public class Provider {

    private Long id;
    private String name;
    private String termsOfDelivery;
    private String aboutCompany;
    private Boolean accepted;
    private LocalDateTime registrationDate;
    private Integer countOfPositiveMarks;
    private Integer countOfNegativeMarks;

    private User user;

    private Set<Delivery> deliveries = new HashSet<Delivery>();

    public Provider() {

    }

    public Provider(String name, String termsOfDelivery, String aboutCompany, Boolean accepted, LocalDateTime registrationDate, Integer countOfPositiveMarks, Integer countOfNegativeMarks) {
        this.name = name;
        this.termsOfDelivery = termsOfDelivery;
        this.aboutCompany = aboutCompany;
        this.accepted = accepted;
        this.registrationDate = registrationDate;
        this.countOfPositiveMarks = countOfPositiveMarks;
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    public Provider(Long id, String name, String termsOfDelivery, String aboutCompany, Boolean accepted, LocalDateTime registrationDate, Integer countOfPositiveMarks, Integer countOfNegativeMarks) {
        this.id = id;
        this.name = name;
        this.termsOfDelivery = termsOfDelivery;
        this.aboutCompany = aboutCompany;
        this.accepted = accepted;
        this.registrationDate = registrationDate;
        this.countOfPositiveMarks = countOfPositiveMarks;
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provider")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "provider_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "terms_of_delivery")
    public String getTermsOfDelivery() {
        return termsOfDelivery;
    }

    public void setTermsOfDelivery(String termsOfDelivery) {
        this.termsOfDelivery = termsOfDelivery;
    }

    @Column(name = "about_company")
    public String getAboutCompany() {
        return aboutCompany;
    }

    public void setAboutCompany(String aboutCompany) {
        this.aboutCompany = aboutCompany;
    }

    @Column(name = "accepted")
    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Column(name = "registration_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "positive_marks")
    public Integer getCountOfPositiveMarks() {
        return countOfPositiveMarks;
    }

    public void setCountOfPositiveMarks(Integer countOfPositiveMarks) {
        this.countOfPositiveMarks = countOfPositiveMarks;
    }

    @Column(name = "negative_marks")
    public Integer getCountOfNegativeMarks() {
        return countOfNegativeMarks;
    }

    public void setCountOfNegativeMarks(Integer countOfNegativeMarks) {
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="id_app_user_fk")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provider provider = (Provider) o;

        if (aboutCompany != null ? !aboutCompany.equals(provider.aboutCompany) : provider.aboutCompany != null)
            return false;
        if (accepted != null ? !accepted.equals(provider.accepted) : provider.accepted != null) return false;
        if (countOfNegativeMarks != null ? !countOfNegativeMarks.equals(provider.countOfNegativeMarks) : provider.countOfNegativeMarks != null)
            return false;
        if (countOfPositiveMarks != null ? !countOfPositiveMarks.equals(provider.countOfPositiveMarks) : provider.countOfPositiveMarks != null)
            return false;
        if (name != null ? !name.equals(provider.name) : provider.name != null) return false;
        if (registrationDate != null ? !registrationDate.equals(provider.registrationDate) : provider.registrationDate != null)
            return false;
        if (termsOfDelivery != null ? !termsOfDelivery.equals(provider.termsOfDelivery) : provider.termsOfDelivery != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (termsOfDelivery != null ? termsOfDelivery.hashCode() : 0);
        result = 31 * result + (aboutCompany != null ? aboutCompany.hashCode() : 0);
        result = 31 * result + (accepted != null ? accepted.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (countOfPositiveMarks != null ? countOfPositiveMarks.hashCode() : 0);
        result = 31 * result + (countOfNegativeMarks != null ? countOfNegativeMarks.hashCode() : 0);
        return result;
    }
}
