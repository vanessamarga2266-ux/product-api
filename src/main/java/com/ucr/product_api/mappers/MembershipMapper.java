package com.ucr.product_api.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.ucr.product_api.Entities.Membership;
import com.ucr.product_api.dtos.MembershipDto;
import com.ucr.product_api.models.MembershipResponseModel;

@Component
public class MembershipMapper {

    public MembershipDto toMembershipDto(Membership membership) {
        if (membership == null) {
            return null;
        }
        /*
         * Si tienen un error en estos métodos, revisar la clase y verificar que los
         * nombres tengan la primera letra en mayúscula
         * o verificar que se llame correctamente
         */
        return new MembershipDto(membership.getId(), membership.getName(), membership.getDescription(),
                membership.getPrice(), membership.getDurationDays());
    }

    public List<MembershipDto> toMembershipDtoList(List<Membership> memberships) {
        if (memberships == null) {
            return null;
        }

        return memberships.stream()
                .map(this::toMembershipDto)
                .collect(Collectors.toList());
    }

    public MembershipResponseModel toMembershipResponseModel(MembershipDto membershipDto) {
        if (membershipDto == null) {
            return null;
        }

        return new MembershipResponseModel(null, membershipDto.name(), membershipDto.description(),
                membershipDto.price(), null);
    }

    public List<MembershipResponseModel> toMembershipResponseModelList(List<MembershipDto> membershipDtos) {
        if (membershipDtos == null) {
            return null;
        }

        return membershipDtos.stream()
                .map(this::toMembershipResponseModel)
                .collect(Collectors.toList());
    }
}
