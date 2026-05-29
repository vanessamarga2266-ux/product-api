package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Payment;

public interface IPaymentService {
    List<Payment> getAll();
}