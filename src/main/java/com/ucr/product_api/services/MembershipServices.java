package com.ucr.product_api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ucr.product_api.Entities.Membership;
import com.ucr.product_api.dtos.MembershipRequestDto;
import com.ucr.product_api.exceptions.MembershipNotFoundException;
import com.ucr.product_api.repositories.MembershipRepository;
 
@Service
public class MembershipServices implements IMembershipServices {
 
    @Autowired
    private MembershipRepository membershipRepository;
 
    @Override
    public List<Membership> getAll() {
 
        return membershipRepository.getAll();
    }

    @Override
    public Membership create(Membership membership) {
        if (membership.getResourceId() == null) {
            membership.setResourceId(UUID.randomUUID());
        }
        return membershipRepository.save(membership);
    }

    @Override
    public Membership addMembership(MembershipRequestDto membershipDto) {
        var membership = Membership
        .builder()
        .name(membershipDto.getName())
        .description(membershipDto.getDescription())
        .resourceId(UUID.randomUUID())
        .build();

        return membershipRepository.save(membership);
    }

    @Override
    public Membership updateMembership(UUID resourceId, MembershipRequestDto membershipDto) {
        var membership = membershipRepository.findByResourceId(resourceId)
        .orElseThrow(() -> new MembershipNotFoundException("Membership no encontrado"));

        membership.setName(membershipDto.getName());
        membership.setDescription(membershipDto.getDescription());

        return membershipRepository.save(membership);
    }

    @Override
    public Membership getByResourceId(UUID resourceId) {
        return membershipRepository.findByResourceId(resourceId)
                .orElseThrow(() -> new MembershipNotFoundException("Membership no encontrado con resourceId"));
    }

    @Override
    public void removeMembership(UUID resourceId) {
       var membership = membershipRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new MembershipNotFoundException("Membership no encontrado"));

        membershipRepository.delete(membership);
    }
}
