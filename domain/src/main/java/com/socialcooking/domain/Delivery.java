package com.socialcooking.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "delivery")
public class Delivery extends DomainObject {

    @Column(name = "price")
    private Integer price;

    @Column(name = "is_prepared")
    private boolean isPrepared;

    @Column(name = "delivery_price")
    private Integer priceDelivery;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provider_fk")
    private Provider provider;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "delivery_has_recipe",
            joinColumns = @JoinColumn(name = "id_delivery_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_recipe_fk"))
    private Set<Recipe> recipes = new HashSet<Recipe>();

    //orphanRemoval = true
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.REFRESH)
    private Set<Order> orders = new HashSet<Order>();

    public Delivery() {

    }

    public Delivery(Long id, Integer price, boolean prepared, Integer priceDelivery) {
        this.id = id;
        this.price = price;
        isPrepared = prepared;
        this.priceDelivery = priceDelivery;
    }

    public Delivery(Integer price, boolean prepared, Integer priceDelivery) {
        this.price = price;
        isPrepared = prepared;
        this.priceDelivery = priceDelivery;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public boolean isPrepared() {
        return isPrepared;
    }

    public void setPrepared(boolean prepared) {
        isPrepared = prepared;
    }


    public Integer getPriceDelivery() {
        return priceDelivery;
    }

    public void setPriceDelivery(Integer priceDelivery) {
        this.priceDelivery = priceDelivery;
    }


    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }


    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }


    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (isPrepared != delivery.isPrepared) return false;
        if (id != null ? !id.equals(delivery.id) : delivery.id != null) return false;
        if (price != null ? !price.equals(delivery.price) : delivery.price != null) return false;
        if (priceDelivery != null ? !priceDelivery.equals(delivery.priceDelivery) : delivery.priceDelivery != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (isPrepared ? 1 : 0);
        result = 31 * result + (priceDelivery != null ? priceDelivery.hashCode() : 0);
        return result;
    }
}
