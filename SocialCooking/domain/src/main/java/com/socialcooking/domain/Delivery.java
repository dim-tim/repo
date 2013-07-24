package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@NamedQueries({
        @NamedQuery(name = "Delivery.findAll", query = "select d from Delivery d"),
        @NamedQuery(name = "Delivery.findById", query = "select d from Delivery d where d.id = :id")})
public class Delivery extends DomainObject {

    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinColumn(name="id_provider_fk")
    private Provider provider;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="id_recipe_fk")
    private Recipe recipe;

    @Column(name = "price")
    private Integer price;

    @Column(name = "is_prepared")
    private boolean isPrepared;

    @Column(name = "delivery_price")
    private Integer priceDelivery;

    public Delivery(){

    }

    public Delivery(Long id, Integer price, boolean prepared, Integer priceDelivery) {
        setId(id);
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Delivery delivery = (Delivery) o;

        if (isPrepared != delivery.isPrepared) return false;
        if (price != null ? !price.equals(delivery.price) : delivery.price != null) return false;
        if (priceDelivery != null ? !priceDelivery.equals(delivery.priceDelivery) : delivery.priceDelivery != null)
            return false;
        if (provider != null ? !provider.equals(delivery.provider) : delivery.provider != null) return false;
        if (recipe != null ? !recipe.equals(delivery.recipe) : delivery.recipe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (isPrepared ? 1 : 0);
        result = 31 * result + (priceDelivery != null ? priceDelivery.hashCode() : 0);
        return result;
    }
}
