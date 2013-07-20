package com.socialcooking.domain;


import javax.persistence.*;

@Entity
@Table(name = "delivery")
@NamedQueries({
        @NamedQuery(name = "Delivery.findAll", query = "select d from Delivery d"),
        @NamedQuery(name = "Delivery.findById", query = "select d from Delivery d where d.id = :id")})
public class Delivery {

    private Long id;
    private Integer price;
    private boolean isPrepared;
    private Integer priceDelivery;

    public Delivery(){

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "is_prepared")
    public boolean isPrepared() {
        return isPrepared;
    }

    public void setPrepared(boolean prepared) {
        isPrepared = prepared;
    }

    @Column(name = "delivery_price")
    public Integer getPriceDelivery() {
        return priceDelivery;
    }

    public void setPriceDelivery(Integer priceDelivery) {
        this.priceDelivery = priceDelivery;
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
