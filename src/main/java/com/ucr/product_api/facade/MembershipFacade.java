package com.ucr.product_api.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.Membership;
import com.ucr.product_api.dtos.MembershipDto;
import com.ucr.product_api.dtos.MembershipRequestDto;
import com.ucr.product_api.mappers.MembershipMapper;
import com.ucr.product_api.services.IMembershipService;

import jakarta.transaction.Transactional;

@Component
public class MembershipFacade implements IMembershipFacade {

    @Autowired
    private IMembershipService membershipService;

    @Autowired
    private MembershipMapper membershipMapper;

    @Override
    public List<MembershipDto> getAll() {
        return membershipMapper.toMembershipDtoList(membershipService.getAll());
    }

    @Override
    public MembershipDto create(MembershipDto membershipDto) {
        Membership membership = Membership.builder()
                .name(membershipDto.name())
                .description(membershipDto.description())
                .price(membershipDto.price())
                .durationDays(membershipDto.durationDays())
                .resourceId(membershipDto.resourceId() == null ? UUID.randomUUID() : membershipDto.resourceId())
                .build();

        Membership saved = membershipService.create(membership);

        return membershipMapper.toMembershipDto(saved);
    }

    @Override
    public MembershipDto addMembership(MembershipRequestDto membershipDto) {
        var entity = membershipService.addMembership(membershipDto);
        return membershipMapper.toMembershipDto(entity);
    }

    @Override
    @Transactional
    public MembershipDto updateMembership(UUID resourceId, MembershipRequestDto membershipDto) {
        var entity = membershipService.updateMembership(resourceId, membershipDto);
        return membershipMapper.toMembershipDto(entity);
    }

    @Override
    public MembershipDto getByResourceId(UUID resourceId) {
        var entity = membershipService.getByResourceId(resourceId);
        return membershipMapper.toMembershipDto(entity);
    }

    @Override
    @Transactional
    public void removeMembership(UUID resourceId) {
        membershipService.removeMembership(resourceId);
    }
}
