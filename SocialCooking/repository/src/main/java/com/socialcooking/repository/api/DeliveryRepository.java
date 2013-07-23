package com.socialcooking.repository.api;

import com.socialcooking.domain.Delivery;

import java.util.List;



public interface DeliveryRepository extends IGenericRepository<Delivery> {

    public Delivery findById(Long id);

    public List<Delivery> findAll();

    public Delivery save(Delivery delivery);

    public Delivery update(Delivery delivery);

    public void delete(Delivery delivery);
}
