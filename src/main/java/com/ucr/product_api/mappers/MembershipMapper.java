package com.ucr.product_api.mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ucr.product_api.Entities.Membership;
import com.ucr.product_api.dtos.MembershipDto;
import com.ucr.product_api.dtos.MembershipRequestDto;
import com.ucr.product_api.models.MembershipRequestModel;
import com.ucr.product_api.models.MembershipResponseModel;

@Component
public class MembershipMapper {
    
    public MembershipDto toMembershipDto(Membership membership){
        if (membership == null) {
            return null;
        }

        return new MembershipDto(membership.getResourceId(), membership.getName(), membership.getDescription(), membership.getPrice(), membership.getDurationDays());
    }

    public List<MembershipDto> toMembershipDtoList(List<Membership> memberships){
        if (memberships == null) {
            return null;
        }

        return memberships.stream()
                .map(this::toMembershipDto)
                .collect(Collectors.toList());
    }

    public MembershipResponseModel toMembershipResponseModel(MembershipDto membershipDto){
        if (membershipDto == null) {
            return null;
        }

        return new MembershipResponseModel(membershipDto.resourceId(), membershipDto.name(), membershipDto.description(), membershipDto.price(), membershipDto.durationDays());
    }

    public List<MembershipResponseModel> toMembershipResponseModelList(List<MembershipDto> membershipDtos){
        if (membershipDtos == null) {
            return null;
        }

        return membershipDtos.stream()
                .map(this::toMembershipResponseModel)
                .collect(Collectors.toList());
    }

    public MembershipRequestDto toMembershipRequestDto(MembershipRequestModel membership){
        if (membership == null) {
            return null;
        }

        return new MembershipRequestDto(membership.name(), membership.description(), membership.price(), membership.durationDays());
    }

    public Membership toMembershipEntity(MembershipRequestDto dto){
        if (dto == null) {
            return null;
        }

        UUID resourceId = dto.resourceId() == null ? UUID.randomUUID() : dto.resourceId();

        return Membership.builder()
        .name(dto.name())
        .description(dto.description())
        .resourceId(resourceId)
        .build();
    }
}