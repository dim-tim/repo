package com.socialcooking.domain;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name= "provider")
@NamedQueries({
        @NamedQuery(name = "Provider.findAll", query = "select p from Provider p"),
        @NamedQuery(name = "Provider.findById", query = "select p from Provider p where p.name = :name")})
public class Provider {

    @Id
    @Column(name = "provider_name")
    private String name;

    @Column(name = "terms_of_delivery")
    private String termsOfDelivery;

    @Column(name = "about_company")
    private String aboutCompany;

    @Column(name = "accepted")
    private Boolean accepted;

    @Column(name = "registration_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime registrationDate;

    @Column(name = "positive_marks")
    private Integer countOfPositiveMarks;

    @Column(name = "negative_marks")
    private Integer countOfNegativeMarks;

    public Provider() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTermsOfDelivery() {
        return termsOfDelivery;
    }

    public void setTermsOfDelivery(String termsOfDelivery) {
        this.termsOfDelivery = termsOfDelivery;
    }

    public String getAboutCompany() {
        return aboutCompany;
    }

    public void setAboutCompany(String aboutCompany) {
        this.aboutCompany = aboutCompany;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }


    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }


    public Integer getCountOfPositiveMarks() {
        return countOfPositiveMarks;
    }

    public void setCountOfPositiveMarks(Integer countOfPositiveMarks) {
        this.countOfPositiveMarks = countOfPositiveMarks;
    }


    public Integer getCountOfNegativeMarks() {
        return countOfNegativeMarks;
    }

    public void setCountOfNegativeMarks(Integer countOfNegativeMarks) {
        this.countOfNegativeMarks = countOfNegativeMarks;
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
