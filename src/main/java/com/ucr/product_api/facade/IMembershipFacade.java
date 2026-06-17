package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import com.ucr.product_api.dtos.MembershipDto;
import com.ucr.product_api.dtos.MembershipRequestDto;

public interface IMembershipFacade {
    List<MembershipDto> getAll();
    public MembershipDto create(MembershipDto membershipDto);
    MembershipDto addMembership(MembershipRequestDto membershipDto);
    MembershipDto updateMembership(UUID resourceId, MembershipRequestDto membershipDto);
    MembershipDto getByResourceId(UUID resourceId);
    void removeMembership(UUID resourceId);
}