package com.socialcooking.domain;


public class Delivery {

    private Long id;
    private Integer price;
    private boolean isWhole;
    private Integer priceDelivery;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isWhole() {
        return isWhole;
    }

    public void setWhole(boolean whole) {
        isWhole = whole;
    }

    public Integer getPriceDelivery() {
        return priceDelivery;
    }

    public void setPriceDelivery(Integer priceDelivery) {
        this.priceDelivery = priceDelivery;
    }
}
