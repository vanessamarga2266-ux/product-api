package com.ucr.product_api.facade;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ucr.product_api.dtos.MembershipDto;
import com.ucr.product_api.mappers.MembershipMapper;
import com.ucr.product_api.services.IMembershipService;
 
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
}
