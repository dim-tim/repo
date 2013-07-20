package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name= "provider")
@NamedQueries({
        @NamedQuery(name = "Provider.findAll", query = "select p from Provider p"),
        @NamedQuery(name = "Provider.findById", query = "select p from Provider p where p.name = :name")})
public class Provider {

    private String name;
    private String termsOfDelivery;
    private String aboutCompany;
    private Boolean accepted;

    @Id
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
}
