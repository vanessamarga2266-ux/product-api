package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Membership;

public interface IMembershipService {
    List<Membership> getAll();
}
