package com.ucr.product_api.services;

import java.util.List;

import com.ucr.product_api.Entities.Membership;
import com.ucr.product_api.repositories.MembershipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MembershipService implements IMembershipService {
    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public List<Membership> getAll() {
        return membershipRepository.findAll();
    }
}