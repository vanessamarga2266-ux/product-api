package com.ucr.product_api.repositories;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.ucr.product_api.Entities.Payment;
 
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    default List<Payment> getAll() {
 
        return findAll();
    }
}