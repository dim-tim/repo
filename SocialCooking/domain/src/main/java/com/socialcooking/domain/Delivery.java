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
}
