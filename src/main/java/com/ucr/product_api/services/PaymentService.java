package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Payment;
import com.ucr.product_api.repositories.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}