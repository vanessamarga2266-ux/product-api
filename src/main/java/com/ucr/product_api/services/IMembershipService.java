package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.Entities.Membership;
import com.ucr.product_api.dtos.MembershipRequestDto;

public interface IMembershipService {
    List<Membership> getAll();

    public Membership create(Membership membership);

    Membership addMembership(MembershipRequestDto membershipDto);

    Membership updateMembership(UUID resourceId, MembershipRequestDto membershipDto);

    Membership getByResourceId (UUID resourceId);

    void removeMembership(UUID resourceId);
}